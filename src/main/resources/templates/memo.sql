SELECT id, name, condition, category, brand, price, shipping, description FROM items ORDER BY id LIMIT 25;
SELECT id, name, condition, c.name_all , brand, price, shipping, description FROM items i INNER JOIN category c ON i.category = c.id ORDER BY id LIMIT 25;