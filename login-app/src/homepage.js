import React from 'react';

function HomePage({ userData }) {
    var data = sessionStorage.getItem("user");
    var userData = JSON.parse(data); 
    console.log(userData)
    return (
        <div className="homepage">
            <h1>Welcome to the Homepage</h1>
            {userData && (
                <div>
                    <p>Name: {userData.name}</p>
                    <p>Username: {userData.userId}</p>
                    <p>Role: {userData.role}</p>
                    {userData.role === "manager" && (
                        <p><a href="/restricted">Manager Dashboard</a></p>
                    )}
                </div>
            )}
        </div>
    );
}

export default HomePage;
