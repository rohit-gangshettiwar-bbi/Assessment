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

 

        data.forEach(country => {

            const countryCard = document.createElement('div');

            countryCard.classList.add('country-card');

            countryCard.innerHTML = `

                <img src="${country.flags.png}" alt="${country.name.common}">

                <h2>${country.name.common}</h2>

                <p>Capital: ${country.capital}</p>

                <p>Population: ${country.population}</p>

            `;

            countryContainer.appendChild(countryCard);

        });

    } catch (error) {

        console.error('Error fetching data:', error);

    }

});
