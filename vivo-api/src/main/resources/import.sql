-- Inserindo Descrições (Description)
INSERT INTO description (id, text, url, category)
VALUES
  ('uuid-1', 'Descrição do Produto A', 'https://produto-a.com', 'general'),
  ('uuid-2', 'Descrição do Produto B', 'https://produto-b.com', 'promotion'),
  ('uuid-3', 'Promoção de Lançamento', 'https://produto-c.com', 'promotion');

-- Inserindo Produtos (Product)
INSERT INTO product (id, product_name, product_type, description_id, subscription_type)
VALUES
  ('uuid-4', 'Produto A', 'mobile', 'uuid-1', 'prepaid'),
  ('uuid-5', 'Produto B', 'internet', 'uuid-2', 'postpaid'),
  ('uuid-6', 'Produto C', 'iptv', 'uuid-3', 'control');

-- Inserindo Preços (Price)
INSERT INTO price (id, description_id, price_type, recurring_period, product_id)
VALUES
  ('uuid-7', 'uuid-1', 'recurring', 'monthly', 'uuid-4'),
  ('uuid-8', 'uuid-2', 'one-off', NULL, 'uuid-5'),
  ('uuid-9', 'uuid-3', 'usage', NULL, 'uuid-6');

-- Inserindo Tags (Tags são um ElementCollection no Product)
INSERT INTO product_tags (product_id, tags)
VALUES
  ('uuid-4', 'promoção'),
  ('uuid-4', 'lançamento'),
  ('uuid-5', 'popular'),
  ('uuid-6', 'premium');
