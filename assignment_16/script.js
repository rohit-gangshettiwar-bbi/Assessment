
let exportedData = [];

let countryData = []; 

// Function to fetch and store country data
async function fetchCountryData() {
    try {
        const response = await fetch('https://restcountries.com/v3.1/all');
        countryData = await response.json();
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

// Call the function to fetch and store country data
fetchCountryData();

const searchForm = document.getElementById('search-form');
const searchInput = document.getElementById('search-input');
const searchOption = document.getElementById('search-option');
const countryContainer = document.getElementById('country-container');

searchForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const searchTerm = searchInput.value.trim().toLowerCase();
    const searchType = searchOption.value;

    if (searchTerm === '') {
        return;
    }

    countryContainer.innerHTML = '';

    countryData.forEach(country => {
        if (searchType === 'name' && country.name.common.toLowerCase().includes(searchTerm)) {
            displayCountryCard(country);
        } else if (searchType === 'currency' && country.currencies && country.currencies[0].toLowerCase().includes(searchTerm)) {
            displayCountryCard(country);
        }
    });
});


// Function to display a country card
function displayCountryCard(country) {
    const countryCard = document.createElement('div');
    countryCard.classList.add('country-card');
    countryCard.innerHTML = `
        <img src="${country.flags.png}" alt="${country.name.common}">
        <h2>${country.name.common}</h2>
        <p>Capital: ${country.capital}</p>
        <p>Population: ${country.population}</p>
    `;


    exportedData.push({
        name: country.name.common,
        capital: country.capital,
        population: country.population,
        img:country.flags.png
    });

    countryContainer.appendChild(countryCard);
}

// Export button click event listener
const exportButton = document.getElementById('export-button');
exportButton.addEventListener('click', () => {
    exportData();
});

// Function to export data as JSON file
function exportData() {
    const dataStr = JSON.stringify(exportedData, null, 2);
    const blob = new Blob([dataStr], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'exported_data.json';
    a.click();
    URL.revokeObjectURL(url);
}
