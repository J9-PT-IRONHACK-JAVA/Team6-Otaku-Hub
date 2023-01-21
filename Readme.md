<img src="docs/1653045471_530623_1653046155_noticia_normal.jpg" alt="otaku-hub" width="1400"/>
<img src="docs/text-1673644554952.png" alt="otaku-hub" width="1400"/>        
<img src="docs/manga-tekeningen.jpg" alt="otaku-hub" width="1400"/>

<div align="center"><h2>SEARCH! STORE! WATCH! and PLAY to our Trivial! Anime Everywhere.</h2></div>

<br>

# Endpoints

## /anime

GET ``http://localhost:80/anime/anime-details``

GET ``http://localhost:80/anime/popular``

GET ``http://localhost:80/anime/sceneImage``

GET ``http://localhost:80/anime/search``

GET ``http://localhost:80/anime/search/byGenre``

GET ``http://localhost:80/anime/search/byScene``

GET ``http://localhost:80/anime/watch``

## /trivial

GET ``http://localhost:80/trivial/quote``

GET ``http://localhost:80/trivial/sceneImage``

## /quote

GET ``http://localhost:80/quote/quotes``

GET ``http://localhost:80/quote/quotes/anime``

GET ``http://localhost:80/quote/quotes/character``

GET ``http://localhost:80/quote/random``

GET ``http://localhost:80/quote/random/anime``

GET ``http://localhost:80/quote/random/character``

## /users

PATCH ``http://localhost:80/users/addanime/{{username}}``

PATCH ``http://localhost:80/users/addpoints/{{username}}``

PATCH ``http://localhost:80/users/admin/updateUserByAdmin/{{username}}``

GET ``http://localhost:80/users/checkuser/{{username}}``

POST ``http://localhost:80/users/create``

DELETE ``http://localhost:80/users/delete/{{username}}``

GET ``http://localhost:80/users/getAll``

GET ``http://localhost:80/users/getByUsername``

PATCH ``http://localhost:80/users/updateByUser/{{username}}``

<br>

# Security: Basic Authorisation
Security is provided by Spring Security
Roles: USER, ADMIN

<br>

# External APIs

### GogoAnime API,
a free anime streaming restful API serving anime from Gogoanime (https://github.com/riimuru/gogoanime-api)

### AnimeChan API,
A free restful API serving quality anime quotes (https://animechan.vercel.app/)

### TraceMoe API,
Anime Scene Seach Engine that can trace back the scene where an anime screenshots is taken from (https://soruly.github.io/trace.moe-api/#/)

Ojo, Euge se deja dinerito :moneybag: .. Ayer a cambiarlo todo para poner apiKey :persevere:

<br>

# Public API Demo (frontend vuejs)
Ngrok betrayed us... :sob:

But comming soon!! :wink:

<br>

Link for Otaku_Hub Front: https://github.com/grumps711/otaku-hub-front-p4b
Open and run serve with VScode

<hr>

_Developed by:_

* Pablo Martínez (Backend)
* Eugeni Puigdomènech (Frontend)
* Andrés Álvarez (Backend and Frontend)

![imagen](https://user-images.githubusercontent.com/83793367/212431897-31723c4c-6160-464c-a01e-aeefc93d6b93.png)

