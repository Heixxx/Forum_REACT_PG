import React, { useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

function Post() {
    const { categoryId } = useParams();
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(
                `http://localhost:8081/addNewPost/${categoryId}`,
                {
                    title,
                    content,
                }
            );
            console.log("Dodano nowy post:", response.data);
            navigate(`/posts/${categoryId}`);
        } catch (error) {
            console.error("Błąd dodawania posta:", error);
            setError("Błąd dodawania posta");
        }
    };

    return (
        <section className="postForm wrapper">
            <div className="icons">
                <div className="iconX">X</div>
                <div className="iconY">Y</div>
                <div className="iconZ">Z</div>
                <div className="iconO">O</div>
            </div>
            <h2 className="logo">Dodaj nowy post</h2>
            {error && <p>{error}</p>}
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="title"
                    value={title}
                    placeholder="Tytuł"
                    required
                    onChange={(e) => setTitle(e.target.value)}
                />
                <br />
                <textarea
                    name="content"
                    value={content}
                    placeholder="Treść"
                    required
                    onChange={(e) => setContent(e.target.value)}></textarea>
                <br />
                <button className="btn" type="submit">Dodaj post</button>
            </form>
        </section>
    );
}

export default Post;
