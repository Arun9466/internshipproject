import React from 'react';
import '../styles/TopBar.css'; // You can create a CSS file for styling
import {useNavigate } from 'react-router-dom';
const TopBar = () => {

    // function TopBar() {
        const navigate = useNavigate()
        const handleLogout = e =>{
            localStorage.removeItem("sessionToken");
            navigate("/");
        }
  return (
    <div className="top-bar">
       {/* <div className="logo"> */}
        {/* Replace 'custom-logo.png' with the path to your custom logo */}
       {/* </div> */}
      <div className="title">
        <span className="cursive-text">Fresh Connect</span>
      </div>
      <div className="search-bar">
        <input
          type="text"
          placeholder="#Explore..."
          className="styled-input"
        />
        <div className="create">
        <label className="btn btn-primary" htmlFor="create-post" onClick={handleLogout}>Logout</label>
        </div>
      </div>
    </div>
  );
};

export default TopBar;