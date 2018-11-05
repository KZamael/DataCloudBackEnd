DELETE FROM products;

insert into products(id, context, data_type, code, identifier, category, name, description, price) VALUES
(1, 'http://schema.org', 'Product', 'P001', 'Prod1', 'Category1' , 'Product 1', 'Product 1 description', 25),
(2, 'http://schema.org', 'Product', 'P002', 'Prod2', 'Category2' , 'Product 2', 'Product 2 description', 32),
(3, 'http://schema.org', 'Product', 'P003', 'Prod3', 'Category3' , 'Product 3', 'Product 3 description', 50)
;