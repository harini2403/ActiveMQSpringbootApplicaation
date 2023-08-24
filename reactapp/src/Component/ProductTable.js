// ProductTable.js
import React from 'react';

const ProductTable = ({product}) => { 
  return (
    <div>
    <table>
      <thead>
        <tr>
          <th>Product ID</th>
          <th>Product Cost</th>
          <th>Product Name</th>
          <th>Product Description</th>
          <th>createdTimestamp</th>
        </tr>
      </thead>
      <tbody>
        {product.map((product) => (
          <tr key={product.productId}>
            <td>{product.productId}</td>
            <td>{product.productCost}</td>
            <td>{product.productName}</td>
            <td>{product.productDescription}</td>
            <td>{product.createdTimestamp}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
  );
};

export default ProductTable;
