-- Insertar productos
INSERT INTO Product (description, amount) VALUES ('Producto 1', 2);
INSERT INTO Product (description, amount) VALUES ('Producto 2', 3);

-- Insertar carrito
INSERT INTO Cart (uuid, last_active_time) VALUES ('123456789', '2023-06-02 12:09:28-04:42:46');

-- Obtener los ids de los productos
SET @productId1 = (SELECT id FROM Product WHERE description = 'Producto 1');
SET @productId2 = (SELECT id FROM Product WHERE description = 'Producto 2');

-- Insertar registros en la tabla de unión
INSERT INTO cart_product (cart_uuid, product_id) VALUES ((SELECT uuid FROM Cart), @productId1);
INSERT INTO cart_product (cart_uuid, product_id) VALUES ((SELECT uuid FROM Cart), @productId2);