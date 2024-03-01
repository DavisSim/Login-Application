import React from 'react';

function RestrictedHomePage({ userData }) {
    var data = sessionStorage.getItem("user");
    var userData = JSON.parse(data); 
    
    if (!userData || userData.role !== "manager") {
        window.location.href = "/ ";
        return null;
    }

    return (
        <div className="homepage">
            <h1>Welcome to restricted manager Homepage</h1>
            {userData && (
                <div>
                    <p>Name: {userData.name}</p>
                    <p>Username: {userData.userId}</p>
                    <p>Role: {userData.role}</p>
                </div>
            )}
        </div>
    );
}

export default RestrictedHomePage;