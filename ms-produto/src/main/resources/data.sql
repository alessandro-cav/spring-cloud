INSERT INTO tb_produto (nome)
  SELECT 'cadeira'
    WHERE NOT EXISTS (SELECT nome FROM tb_produto WHERE id = 1);
    INSERT INTO tb_produto (nome)
  SELECT 'mesa'
    WHERE NOT EXISTS (SELECT nome FROM tb_produto WHERE id = 2);

