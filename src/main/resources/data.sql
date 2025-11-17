-- Inserir algumas bombas de combustível com status inicial
INSERT INTO bomba_combustivel (numero, status, combustivel, preco_litro) VALUES (1, 'DISPONIVEL', 'Gasolina Comum', 5.59) ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba_combustivel (numero, status, combustivel, preco_litro) VALUES (2, 'DISPONIVEL', 'Gasolina Aditivada', 5.79) ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba_combustivel (numero, status, combustivel, preco_litro) VALUES (3, 'DISPONIVEL', 'Etanol', 3.69) ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba_combustivel (numero, status, combustivel, preco_litro) VALUES (4, 'DISPONIVEL', 'Diesel S10', 6.09) ON CONFLICT (numero) DO NOTHING;
