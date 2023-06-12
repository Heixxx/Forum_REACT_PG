import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import "./css/style.css";

function PostDetails() {
  const { idPost } = useParams();
  const [post, setPost] = useState(null);
  const [comments, setComments] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [showComments, setShowComments] = useState(false);
  const [newComment, setNewComment] = useState("");
  const [editingCommentId, setEditingCommentId] = useState(null);
  const [editedComment, setEditedComment] = useState("");

  useEffect(() => {
    fetchData();
  }, [idPost]);

  const fetchData = async () => {
    try {
      const [postResponse, commentsResponse] = await Promise.all([
        axios.get(`http://localhost:8081/post/${idPost}`),
        axios.get(`http://localhost:8081/commentsPost/${idPost}`),
      ]);
      setPost(postResponse.data);
      setComments(commentsResponse.data);
      setIsLoading(false);
    } catch (error) {
      console.error("Błąd pobierania danych:", error);
      setIsLoading(false);
    }
  };

  const formatTime = (timestamp) => {
    const date = new Date(timestamp);
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const day = date.getDate().toString().padStart(2, "0");
    const hours = date.getHours().toString().padStart(2, "0");
    const minutes = date.getMinutes().toString().padStart(2, "0");
    return `${year}/${day}/${month} ${hours}:${minutes}`;
  };

  const handleToggleComments = () => {
    setShowComments(!showComments);
  };

  const handleCommentChange = (event) => {
    setNewComment(event.target.value);
  };

  const handleAddComment = async () => {
    try {
      const response = await axios.post(`http://localhost:8081/addComment`, {
        comment: newComment,
        author: localStorage.getItem('username'),
        idComment:4,
        idPost: post,
      });

      const newCommentData = response.data;
      setComments((prevComments) => [...prevComments, newCommentData]);

      setNewComment('');

      fetchData();
      console.log('Dodano nowy komentarz');
    } catch (error) {
      console.error('Błąd dodawania komentarza:', error);
    }
  };

  const handleDeleteComment = async (commentId) => {
    try {
      await axios.get(`http://localhost:8081/deleteComment/${commentId}`);
      setComments((prevComments) => prevComments.filter((comment) => comment.idComment !== commentId));
      console.log('Usunięto komentarz');
    } catch (error) {
      console.error('Błąd usuwania komentarza:', error);
    }
  };

  const handleEditComment = (commentId, commentText) => {
    setEditingCommentId(commentId);
    setEditedComment(commentText);
  };

  const handleSaveChanges = async (commentId) => {
    try {
      await axios.post(`http://localhost:8081/updateComment`, {
        idComment: commentId,
        comment: editedComment,
        author: localStorage.getItem('username'),
        idPost: post,
      });

      setEditingCommentId(null);
      setEditedComment('');

      fetchData();
      console.log('Zapisano zmiany w komentarzu');
    } catch (error) {
      console.error('Błąd zapisywania zmian w komentarzu:', error);
    }
  };

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <section className="postDetails wrapper">
      <div className="icons">
        <div className="iconX">X</div>
        {localStorage.getItem('username') === 'admin' && (
          <div className="iconEdit"></div>
        )}
        <div className="iconY">Y</div>
        <div className="iconZ">Z</div>
        <div className="iconO">O</div>
      </div>
      <div className="postTable btn-anim">
        <h2 className="postLogo logo">{post.title}</h2>
        <p className="postTime">czas: {formatTime(post.createTime)}</p>
        <label className="content wrapper">
          <p className="postContent">{post.content}</p>
        </label>
        <button className="btnComment btn" onClick={handleToggleComments}>
          {showComments ? "Ukryj komentarze" : "Pokaż komentarze"}
        </button>
        {showComments && (
          <div className="comments">
            <h3 className="commentTitle">Komentarze:</h3>
            <ul>
              {comments.map((comment) => (
                <li key={comment.idComment}>
                  <span className="commentAuthor">{comment.author}:</span>
                  {editingCommentId === comment.idComment ? (
                    <>
                      <textarea
                        className="commentInput"
                        value={editedComment}
                        onChange={(e) => setEditedComment(e.target.value)}
                      ></textarea>
                      <button
                        className="btnSaveChanges"
                        onClick={() => handleSaveChanges(comment.idComment)}
                      >
                        Zapisz zmiany
                      </button>
                    </>
                  ) : (
                    <>
                      <span className="commentTxt">{comment.comment}</span>
                      {localStorage.getItem('username') === 'admin' && (
                        <>
                          <button
                            className="btnEditComment"
                            onClick={() => handleEditComment(comment.idComment, comment.comment)}
                          >
                            Edytuj
                          </button>
                          <button
                            className="btnDeleteComment"
                            onClick={() => handleDeleteComment(comment.idComment)}
                          >
                            X
                          </button>
                        </>
                      )}
                    </>
                  )}
                </li>
              ))}
            </ul>
            <div className="addComment">
              <textarea
                className="commentInput"
                placeholder="Dodaj komentarz..."
                value={newComment}
                onChange={handleCommentChange}
              ></textarea>
              <button className="btnAddComment btn" onClick={handleAddComment}>
                Dodaj komentarz
              </button>
            </div>
          </div>
        )}
      </div>
    </section>
  );
}

export default PostDetails;
