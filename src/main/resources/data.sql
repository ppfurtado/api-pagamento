INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('12345678910', 'BOLETO', null, 1000.50, 'PENDENTE');

INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('11222333000144', 'PIX', null, 250.75, 'PENDENTE');

INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('99988877766', 'CARTAO_CREDITO','9999888877776666', 500.00, 'SUCESSO');

INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('11122233344', 'CARTAO_CREDITO','7777888899990000', 2000.00, 'SUCESSO');

INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('99988877766', 'CARTAO_DEBITO','6666555544443333', 350.25, 'FALHA');

INSERT INTO pagamento (CPF_CNPJ, METODO_PAGAMENTO, NUMERO_CARTAO, VALOR_PAGAMENTO, STATUS)
VALUES ('12345678910', 'PIX', null, 5000.00, 'FALHA');