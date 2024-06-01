-- Criação da tabela 'clientes'
CREATE TABLE tb_client (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          idade INTEGER NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          saldo NUMERIC(10, 2) DEFAULT 0,
                          numero_conta VARCHAR(20) NOT NULL UNIQUE
);

-- Criação da tabela 'transacoes'
CREATE TABLE tb_transaction (
                            id SERIAL PRIMARY KEY,
                            cliente_id INTEGER NOT NULL,
                            descricao VARCHAR(250) NOT NULL,
                            tipo_transacao VARCHAR(10) CHECK (tipo_transacao IN ('debito', 'credito')) NOT NULL,
                            valor NUMERIC(10, 2) NOT NULL CHECK (valor > 0),
                            data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (cliente_id) REFERENCES tb_client (id)
);
