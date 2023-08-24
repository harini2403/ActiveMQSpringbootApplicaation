import React, { useState, useEffect } from 'react';
import './App.css';
import ProductForm from './Component/ProductForm';
import ProductTable from './Component/ProductTable';
import Pagination from './Component/Pagination';

function App() {
  // Define a state variable to hold the product data
  const [product, setProduct] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5;
  // Example: Fetch product data from the backend (replace with your actual API endpoint)
  useEffect(() => {
    fetch('http://localhost:8080/products/getAllProducts')
      .then((response) => response.json())
      .then((data) => setProduct(data))
      .catch((error) => console.error('Error fetching products:', error));
  }, []);

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentProducts = product.slice(indexOfFirstItem, indexOfLastItem);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <div className="App">
      <ProductForm />
      <ProductTable product={currentProducts} />
      <Pagination
        itemsPerPage={itemsPerPage}
        totalItems={product.length}
        currentPage={currentPage}
        paginate={paginate}
      />

    </div>
  );
}

export default App;
