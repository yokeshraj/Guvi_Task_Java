
//Using Compass
// 1. Find all the information about each product
{
    // No filter needed, this returns all documents
  }
  
  // 2. Find the product prices that are between 400 to 800
  {
    "product_price": { "$gte": 400, "$lte": 800 }
  }
  
  // 3. Find the product prices that are not between 400 to 600
  {
    "product_price": { "$not": { "$gte": 400, "$lte": 600 } }
  }
  
  // 4. List the first four products which have a price greater than 500
  {
    "product_price": { "$gt": 500 }
  }
  // In MongoDB Compass, you would limit the results to 4 using the `Limit` option
  
  // 5. Find the product name and product material of each product
  {
    // No filter needed, just use Projection to include only "product_name" and "product_material"
  }
  // In MongoDB Compass, set `product_name` and `product_material` to `1` in the `Project` section
  
  // 6. Find the product with a rowid of 10
  {
    "id": "10"
  }
  
  // 7. Find only the product name and product material
  {
    // No filter needed, just use Projection to include only "product_name" and "product_material"
  }
  // In MongoDB Compass, set `product_name` and `product_material` to `1` in the `Project` section
  
  // 8. Find all products which contain the value 'soft' in product_material
  {
    "product_material": { "$regex": "soft", "$options": "i" }
  }
  
// 9. Find products where product price is 492.00 and product color is indigo
{
    "product_price": 492.00,
    "product_color": "indigo"
  }
  

  
  // 10. Delete the products which have a product price value of 28
  {
    "product_price": 28
  }
  // In MongoDB Compass, select the documents and choose to delete them
  
  
//Using CLI
// 1. Find all the information about each product
db.products.find({})

// 2. Find the product prices that are between 400 to 800
db.products.find({ product_price: { $gte: 400, $lte: 800 } })

// 3. Find the product prices that are not between 400 to 600
db.products.find({ product_price: { $not: { $gte: 400, $lte: 600 } } })

// 4. List the first four products which have a price greater than 500
db.products.find({ product_price: { $gt: 500 } }).limit(4)

// 5. Find the product name and product material of each product
db.products.find({}, { _id: 0, product_name: 1, product_material: 1 })

// 6. Find the product with a rowid of 10
db.products.find({ id: "10" })

// 7. Find only the product name and product material
db.products.find({}, { _id: 0, product_name: 1, product_material: 1 })

// 8. Find all products which contain the value 'soft' in product_material
db.products.find({ product_material: { $regex: "soft", $options: "i" } })

// 9. Find products which contain product_code (assuming it exists) and product_price 400.00

db.products.find({ product_price: 492.00, product_color: "indigo" })


// 10. Delete the products which have a product price value of 28
db.products.deleteMany({ product_price: 28 })
