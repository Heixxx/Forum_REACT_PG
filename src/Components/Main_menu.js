import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { encode } from "base-64";
import "./css/style.css";

function CategoryList() {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);


    const fetchData = async () => {
        try {
            const username = localStorage.getItem('username');
            const password = localStorage.getItem('password');
            console.log(username);
            console.log("test");
            const response = await axios.get(
                "http://localhost:8081/getAllCategory",
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + encode(username + ":" + password)
                    }
                }
            );
            setCategories(response.data);
        } catch (error) {
            console.error("Błąd pobierania danych:", error);
        }
    };

    return (
        <section className="mainList btn-anim wrapper">
            <div className="icons">
              <div className="iconX">X</div>
              <div className="iconY">Y</div>
              <div className="iconZ">Z</div>
              <div className="iconO">O</div>
            </div>
            <div className="categoryList">
                <h2 className="categoryLogo logo">Lista kategorii:</h2>
                <ul>
                    {categories.map((category) => (
                        <li key={category.idCategory}>
                            <Link to={`/posts/${category.idCategory}`}>
                                {category.name}
                            </Link>
                        </li>
                    ))}
                </ul>
            </div>
        </section>
    );
}

export default CategoryList;
