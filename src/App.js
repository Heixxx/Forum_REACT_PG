import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, Navigate } from 'react-router-dom';
import Index from './Components/index';
import CategoryList from './Components/Main_menu';
import PostList from './Components/postList';
import PostDetails from './Components/PostDetails';
import Login from './Components/Login';
import Register from './Components/Register';
import Post from './Components/Post'; // Dodany import Post
import "./Components/css/style.css";

function AboutPage() {
  return <h1>O nas</h1>;
}

function ContactPage() {
  return <h1>Kontakt</h1>;
}

function Navigation({ loggedIn, handleLogout }) {
  const username = localStorage.getItem('username');

  return (
    <nav>
      <ul>
        <li>
          <Link className='beta_logo' to="/">Projekt <span> Beta</span></Link>
        </li>
        {!loggedIn && (
          <div className='login btn-anim'>
            <li>
              <Link to="/login">Logowanie</Link>
            </li>
            <li>
              <Link to="/register">Rejestracja</Link>
            </li>
          </div>
        )}
        {loggedIn && (
          <div className='login'>
            <li>
              <span className='userName'>{username}</span>
            </li>
            <div className='btn-anim'>
              <li>
                <Link to="/" onClick={handleLogout}>Wyloguj</Link>
              </li>

            </div>
          </div>
        )}
      </ul>
    </nav>
  );
}

function App() {
  const [loggedIn, setLoggedIn] = useState(!!localStorage.getItem('username'));

  const handleLogin = (username) => {
    localStorage.setItem('username', username);
    setLoggedIn(true);
  };

  const handleLogout = () => {
    localStorage.removeItem('username');
    setLoggedIn(false);
  };

  return (
    <Router>
      <Navigation loggedIn={loggedIn} handleLogout={handleLogout} />
      <Routes>
        <Route path="/" element={<Index loggedIn={loggedIn} handleLogout={handleLogout} />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/categories" element={<CategoryList />} />
        <Route path="/login" element={<Login handleLogin={handleLogin} />} />
        <Route path="/register" element={<Register />} />
        <Route path="/posts/:categoryId" element={<PostList />} />
        <Route path="/post/:idPost" element={<PostDetails />} />
        <Route path="/posts/:categoryId/add" element={<Post />} /> {/* Dodana ścieżka dla dodawania posta */}
      </Routes>
    </Router>
  );
}

export default App;
