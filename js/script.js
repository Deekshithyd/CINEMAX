const registerForm = document.getElementById("registerForm");

if(registerForm){

    registerForm.addEventListener("submit", async function(event){

        event.preventDefault();

        const userData = {

            name: document.getElementById("name").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value

        };

        try{

            const response = await fetch("https://cinemax-1-5ql6.onrender.com/user/register", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(userData)

            });

            const message = await response.text();

            if(message.includes("User Registered Successfully")){

                window.location.replace("login.html");
            }

        }

        catch(error){

            console.log(error);

        }

    });

}

const loginForm = document.getElementById("loginForm");

if(loginForm){

    loginForm.addEventListener("submit", async function(event){

        event.preventDefault();

        const loginData = {

            email: document.getElementById("loginEmail").value,
            password: document.getElementById("loginPassword").value

        };

        try{

            const response = await fetch("https://cinemax-1-5ql6.onrender.com/user/login", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(loginData)

            });

            const token = await response.text();

            if(token !== "Invalid Email or Password"){

                localStorage.setItem(
"token",
token
);

const username =

loginData.email.split("@")[0];

localStorage.setItem(
"username",
username
);

localStorage.setItem(
"email",
loginData.email
);

if(

loginData.email ===
"admin@gmail.com"

){

    localStorage.setItem(
    "role",
    "admin"
    );
}

else{

    localStorage.setItem(
    "role",
    "user"
    );
}

window.location.replace(
"index.html"
);
            }

            else{

                alert(token);
            }

        }

        catch(error){

            console.log(error);

        }

    });

}

function logoutUser(){

    localStorage.removeItem("token");

    localStorage.removeItem("username");

    localStorage.removeItem("role");

    localStorage.removeItem("email");

    window.location.replace("login.html");
}

const welcomeUser =
    document.getElementById("welcomeUser");

if(welcomeUser){

    const username =
        localStorage.getItem("username");

    welcomeUser.innerText =
        "Welcome, " + username;
}

const searchBar =
document.querySelector(
".search-bar"
);

const searchResults =
document.querySelector(
".search-results"
);

if(searchBar){

    searchBar.addEventListener(
    "keyup",

    function(){

        const movieName =
        searchBar.value;

        if(movieName.length === 0){

            searchResults.style.display =
            "none";

            return;
        }

        fetch(
        "https://cinemax-1-5ql6.onrender.com/movies/search/"
        + movieName
        )

        .then(response => response.json())

        .then(movies => {

            searchResults.innerHTML = "";
                        searchResults.style.display =
            "block";

            movies.forEach(movie => {

                searchResults.innerHTML += `

<div class="search-item-text"

onclick="openMovie(

'${movie.title}',

'${movie.image}',

'${movie.info}',

'${movie.description}',

'${movie.trailer}'

)">

 ${movie.title}

</div>

`;
            });

            if(movies.length === 0){

                searchResults.innerHTML = `

                <div class="search-item">

                    No Movies Found

                </div>

                `;
            }

        });

    });

}


function openMovie(title, image, info, description, trailer){

    localStorage.setItem(
        "movieTitle",
        title
    );

    localStorage.setItem(
        "movieImage",
        image
    );

    localStorage.setItem(
        "movieInfo",
        info
    );

    localStorage.setItem(
        "movieDescription",
        description
    );

    localStorage.setItem(
    "movieTrailer",
    trailer
    );

    let recentMovies =
    JSON.parse(
    localStorage.getItem("recentMovies")
    ) || [];

    recentMovies =

recentMovies.filter(function(movie){

    return movie.title !== title;
});

recentMovies.unshift({

    title:title,

    image:image
});

if(recentMovies.length > 10){

    recentMovies.pop();
}

localStorage.setItem(

"recentMovies",

JSON.stringify(recentMovies)

);

    window.location.href =
    "movie.html";
}

function downloadMovie(title, image){

    fetch(

        "https://cinemax-1-5ql6.onrender.com/downloads/add",

        {

            method:"POST",

            headers:{

                "Content-Type":"application/json"
            },

            body:JSON.stringify({

                movieTitle:title,

                movieImage:image
            })
        }

    )

    .then(response => response.text())

    .then(data => {

        showNotification(
            title + " Downloaded"
        );
    })

    .catch(error => {

        console.log(error);
    });
}

function addToWatchlist(title, image){

    fetch(

        "https://cinemax-1-5ql6.onrender.com/watchlist/add",

        {

            method:"POST",

            headers:{

                "Content-Type":"application/json"
            },

            body:JSON.stringify({

                movieTitle:title,

                movieImage:image
            })
        }

    )

    .then(response => response.text())

    .then(data => {

        showToast(
            "✔ " + title + " Added To Watchlist"
        );
    })

    .catch(error => {

        console.log(error);
    });
}


function toggleCategories(){

    document.getElementById(
    "categoriesPopup"
    )

    .classList.toggle(
    "active"
    );
}

function loadCategory(category){

    const container =
    document.getElementById(
    "moviesContainer"
    );

    container.innerHTML = "";

    let url =
    "https://cinemax-1-5ql6.onrender.com/movies/all";

    if(category !== "All"){

        url =
        "https://cinemax-1-5ql6.onrender.com/movies/category/"
        + category;
    }

    fetch(url)

    .then(response => response.json())

    .then(movies => {

        movies.forEach(function(movie){

            container.innerHTML += `

            <div class="movie-card"

            onclick="openMovie(
'${movie.title}',
'${movie.image}',
'${movie.info}',
'${movie.description}',
'${movie.trailer}'
)">

                <img src="${movie.image}">

                <div class="play-btn">
                    ▶
                </div>

                <h2>${movie.title}</h2>

                <p>${movie.info}</p>

                <button>

                    Watch Now

                </button>

                <button class="watchlist-btn"

                onclick="event.stopPropagation();

                addToWatchlist(
                '${movie.title}',
                '${movie.image}'
                )">

                    + Watchlist

                </button>

            </div>

            `;
        });

    });

}
function toggleCategoryList(){

    const list =

    document.getElementById(
    "categoryList"
    );

    if(

    list.style.display ===
    "block"

    ){

        list.style.display =
        "none";
    }

    else{

        list.style.display =
        "block";
    }
}

window.addEventListener(

"DOMContentLoaded",

function(){

    const role =

    localStorage.getItem(
    "role"
    );

    if(role === "admin"){

        const profileMenu =
        document.getElementById(
        "profileMenu"
        );

        const subscriptionMenu =
        document.getElementById(
        "subscriptionMenu"
        );

        const watchlistMenu =
        document.getElementById(
        "watchlistMenu"
        );

        const downloadMenu =
        document.getElementById(
        "downloadMenu"
        );

        const categoriesMenu =
        document.getElementById(
        "categoriesMenu"
        );

        const categoryList =
        document.getElementById(
        "categoryList"
        );

        if(profileMenu)
        profileMenu.style.display =
        "none";

        if(subscriptionMenu)
        subscriptionMenu.style.display =
        "none";

        if(watchlistMenu)
        watchlistMenu.style.display =
        "none";

        if(downloadMenu)
        downloadMenu.style.display =
        "none";

        if(categoriesMenu)
        categoriesMenu.style.display =
        "none";

        if(categoryList)
        categoryList.style.display =
        "none";
    }

    else{

        const adminMenu =
        document.getElementById(
        "adminMenu"
        );

        if(adminMenu){

            adminMenu.style.display =
            "none";
        }
    }

});
function showToast(message){

    const toast =

    document.getElementById(
    "toast"
    );

    toast.innerText = message;

    toast.classList.add("show");

    setTimeout(function(){

        toast.classList.remove(
        "show"
        );

    },2500);
}