import React, { useState } from "react";

const ProductForm = ()=> {
  const [product, setProduct] = useState({
    productCost: "",
    productName: "",
    productCategory: "",
    productDescription: "",
    createdTimestamp: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setProduct({ ...product, [name]: value });
  };
  const handleSubmit = (event) => {
    event.preventDefault();

    fetch("http://localhost:8080/products/createProduct/MQSendMessage", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    })
      .then((response) => {
        if (response.ok) {
          console.log("Product saved successfully!",product);
          setProduct({
            productCost: "",
            productName: "",
            productCategory: "",
            productDescription: "",
            createdTimestamp: "",
          });
        } else {
          console.error("Failed to save product:", response.statusText);
        }
      })
      .catch((error) => {
        console.error("Error saving product:", error);
      });
  };

  return (
    <div>
      <h1>Product Form</h1>
      <form onSubmit={handleSubmit}>
       
        <div>
          <label>Product Cost:</label>
          <input
            type="number"
            name="productCost"
            value={product.productCost}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Product Name:</label>
          <input
            type="text"
            name="productName"
            value={product.productName}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Product Category:</label>
          <input
            type="text"
            name="productCategory"
            value={product.productCategory}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Product Description:</label>
          <textarea
            name="productDescription"
            value={product.productDescription}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Created Timestamp:</label>
          <input
            type="datetime-local"
            name="createdTimestamp"
            value={product.createdTimestamp}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default ProductForm;
