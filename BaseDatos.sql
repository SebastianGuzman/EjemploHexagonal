-- Crear la base de datos si no existe y usarla
CREATE DATABASE IF NOT EXISTS microservice_db;
USE microservice_db;

-- Crear tabla para persona si no existe
CREATE TABLE IF NOT EXISTS persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    genero VARCHAR(20),
    edad INT,
    identificacion VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(15)
);

-- Crear tabla para cliente si no existe
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    estado VARCHAR(50),
    persona_id INT,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

-- Crear tabla para cuenta si no existe
CREATE TABLE IF NOT EXISTS cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL,
    tipo_cuenta VARCHAR(50),
    saldo_inicial DECIMAL(15,2),
    estado VARCHAR(50),
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Crear tabla de movimientos si no existe
CREATE TABLE IF NOT EXISTS movimiento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento VARCHAR(50),
    valor DECIMAL(15,2),
    saldo DECIMAL(15,2),
    cuenta_id INT,
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
);