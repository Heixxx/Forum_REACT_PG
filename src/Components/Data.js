import React, { useState, useEffect } from 'react';
import axios from 'axios';

function PostList() {
  const [posts, setPosts] = useState([]);
  const [newPost, setNewPost] = useState({
    title: '',
    content: '',
    idCategory: '1'
  });

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8081/getAllCategory');
      setPosts(response.data);
    } catch (error) {
      console.error('Błąd pobierania danych:', error);
    }
  };

  const handleInputChange = (e) => {
    setNewPost({ ...newPost, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8081/addNewPost', {
        title: newPost.title,
        content: newPost.content,
        idCategory: newPost.idCategory
      });

      setNewPost({ title: '', content: '' });
      //await fetchData(); // Odświeżenie danych po dodaniu nowego postu
    } catch (error) {
      console.error('Błąd dodawania postu:', error);
    }
  };

  return (
    <div>
      <h2>Lista postów:</h2>
      <ul>
        {posts.map((post) => (
          <li key={post.idCategory}>
            <strong>ID komentarza:</strong> {post.idCategory}, <br />
            <strong>Treść komentarza:</strong> {post.name}, <br />
          </li>
        ))}
      </ul>

      <h2>Dodaj nowy post:</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            name="title"
            value={newPost.title}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Content:</label>
          <input
            type="text"
            name="content"
            value={newPost.content}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Dodaj post</button>
      </form>
    </div>
  );
}

function Data() {
  return (
    <div>
      <h1>Moja aplikacja React z pobieraniem i dodawaniem danych do bazy danych</h1>
      <PostList />
    </div>
  );
}

export default Data;