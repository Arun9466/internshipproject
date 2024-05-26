import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import '../styles/BottomBar.css'; // Import the CSS for styling


const BottomBar = () => {
  const location = useLocation();
  
  return (
    <div className="bottom-bar">
      {/* Home */}
      <Link to="/" className={`icon ${location.pathname === '/' ? 'active' : ''}`}>
        <i className="fa fa-home"></i>
        <span>Home</span>
      </Link>

      {/* Post */}
      <Link to="/create-post" className={`icon ${location.pathname === '/create-post' ? 'active' : ''}`} >
        <i className="fa fa-plus-circle"></i>
        <span>Create</span>
      </Link>

      {/* My Connection */}
      <Link to="/my-connection" className={`icon ${location.pathname === '/my-connection' ? 'active' : ''}`}>
        {/* Custom Bootstrap connection icon */}
        <img src="/people-fill.svg" alt="My Connection" className="custom-icon" />
        <span>My Connection</span>
      </Link>

      {/* Notifications */}
      <Link to="/notifications" className={`icon ${location.pathname === '/notifications' ? 'active' : ''}`}>
        <i className="fa fa-bell"></i>
        <span>Notifications</span>
      </Link>
    </div>
  );
};

export default BottomBar;