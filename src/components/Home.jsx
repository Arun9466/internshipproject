import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';
import Sidebar from './Sidebar';
// import TopBar from './TopBar';
import Main from './Main';
import Right from './Right';
import BottomBar from './BottomBar';

function Home() {
    const navigate = useNavigate()
    useEffect(() => {
        if(!localStorage.getItem('sessionToken')){
            navigate('/')
        } 
    },[])
    // const handleMyPost = e =>{
    //     navigate('/home/myposts')
    // }

    return (
        <>
        <Navbar/>
        <main>
        <div className='container'>
        <Sidebar/>
        <Main/>
       
        </div>
        <div className="bottom-bar-container"> <BottomBar/ ></div>
        </main>
        </>
      );
}

export default Home;