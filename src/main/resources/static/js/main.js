let bookContainer = document.querySelector(".search");
let searchBooks = document.getElementById("search-box");

const debounce = (fn, time, to = 0) => {
	to ? clearTimeout(to) : (to = setTimeout(showSearchedBooks, time));
};
searchBooks.addEventListener("input", () => debounce(showSearchedBooks(), 2000));

//utilizing fetch callback
const getBooks = async (book) => {
	const response = await fetch(
		`https://www.googleapis.com/books/v1/volumes?q=${book}`
	);
	const data = await response.json();
	return data;
};

//shows thumbnail and returns a default thumbnail if a cover is not available for book.
const getThumbnail = ({ imageLinks }) => {
	const journeyThumbnail= "book/icon.svg"; //Need a default thumbnail for books without covers
	if (!imageLinks || !imageLinks.thumbnail) {
		return journeyThumbnail;
	}
	return imageLinks.thumbnail;
};
