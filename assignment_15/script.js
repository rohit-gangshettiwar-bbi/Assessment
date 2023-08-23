let countryData=[];
const searchForm = document.getElementById('search-form');

const searchInput = document.getElementById('search-input');

const countryContainer = document.getElementById('country-container');

 

 

searchForm.addEventListener('submit', async (e) => {

    e.preventDefault();

    const searchTerm = searchInput.value.trim();

 

    if (searchTerm === '') {

        return;

    }

 

    try {

        let response;

        if (searchTerm.length === 3) {
            // Search by currency code
            response = await fetch(`https://restcountries.com/v3.1/currency/${searchTerm}`);
        } else {
            // Search by country name
            response = await fetch(`https://restcountries.com/v3.1/name/${searchTerm}`);
        }

        const data = await response.json();

 

        // Assuming the API response is an array of country objects

        countryContainer.innerHTML = '';

 

        if (Array.isArray(data) && data.length > 0) {
            data.forEach(country => {
                const countryCard = createCountryCard(country);
                countryContainer.appendChild(countryCard);
            });
        } else if (!Array.isArray(data) && data.hasOwnProperty('name')) {
            const countryCard = createCountryCard(data);
            countryContainer.appendChild(countryCard);
        } else {
            displayErrorMessage();
        }

    } catch (error) {
        console.error('Error fetching data:', error);
    }
});

function createCountryCard(country) {
    const countryCard = document.createElement('div');
    countryCard.classList.add('country-card');
    countryCard.innerHTML = `
        <img src="${country.flags.png}" alt="${country.name.common}">
        <h2>${country.name.common}</h2>
        <p>Capital: ${country.capital}</p>
        <p>Population: ${country.population}</p>
    `;
    return countryCard;
}

function displayErrorMessage() {
    countryContainer.innerHTML = '<p class="error-message">No country or currency found. Please try again.</p>';
}
