public class Esercizio4 {
    
}



// Query per vedere tutti i film usciti dopo il 2005
SELECT title, release_year
FROM film
WHERE release_year > 2005
ORDER BY title ASC;


// Mostra tutti i noleggi effettuati da Mary Smith. 
SELECT r.rental_id, r.rental_date, r.return_date, f.title AS titoloFilm
FROM rental AS r
JOIN customer AS c ON r.customer_id = c.customer_id
JOIN inventory AS i ON r.inventory_id = i.inventory_id
JOIN film AS f ON i.film_id = f.film_id
WHERE c.first_name = 'MARY' AND c.last_name = 'SMITH';


// Per ogni film, mostra il numero totale di volte in cui è stato noleggiato. 
SELECT f.title AS titoloFilm, COUNT(r.rental_id) AS noleggiTotali
FROM film AS f
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
GROUP BY  f.film_id, f.title
ORDER BY total_rentals DESC, film_title ASC;


//Elenca i nomi dei film che non sono mai stati noleggiati. 
SELECT f.title AS titoloFilm
FROM film AS f
LEFT JOIN inventory AS i ON f.film_id = i.film_id
LEFT JOIN rental AS r ON i.inventory_id = r.inventory_id
WHERE r.rental_id IS NULL;


//Trova il genere (category) con il maggior numero di noleggi.
SELECT c.name AS nomeCategoria, COUNT(r.rental_id) AS noleggiTotali
FROM category AS c
JOIN film_category AS fc ON c.category_id = fc.category_id
JOIN film AS f ON fc.film_id = f.film_id
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
GROUP BY c.name
ORDER BY noleggiTotali DESC
LIMIT 1;