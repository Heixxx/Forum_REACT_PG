import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, Link, useNavigate } from "react-router-dom";
import "./css/style.css";

function PostList() {
  const { categoryId } = useParams();
  const [posts, setPosts] = useState([]);
  const navigate = useNavigate(); // Dodany hook useNavigate

  useEffect(() => {
    fetchData();
  }, [categoryId]);

  const fetchData = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8081/getAllPostsInCategory/${categoryId}`
      );
      setPosts(response.data);
    } catch (error) {
      console.error("Błąd pobierania danych:", error);
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

  const handleAddPost = async () => {
    navigate(`/posts/${categoryId}/add`); // Przekierowanie do strony Post.js z odpowiednim categoryId
  };

  useEffect(() => {
    fetchData();
  }, [categoryId]);

  return (
    <section className="postList wrapper">
      <div className="icons">
        <div className="iconX">X</div>
        <div className="iconY">Y</div>
        <div className="iconZ">Z</div>
        <div className="iconO">O</div>
      </div>
      <div className="postTable  btn-anim">
        <h2 className="postLogo logo">Lista postów:</h2>
        <ul>
          {posts.map((post) => (
            <div key={post.idPost}> {/* Dodany unikalny klucz */}
              <li>
                <Link to={`/post/${post.idPost}`}>
                  <h3>{post.title}</h3>
                  <p>czas: {formatTime(post.createTime)}</p>
                </Link>
              </li>
            </div>
          ))}
        </ul>
        <button className="btn" onClick={handleAddPost}>Dodaj nowy post</button> {/* Przycisk do dodawania nowego posta */}
      </div>
    </section>
  );
}

export default PostList;
