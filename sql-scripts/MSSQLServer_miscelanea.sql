DROP DATABASE IF EXISTS miscelanea;

IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'miscelanea')
CREATE DATABASE miscelanea;

GO
USE miscelanea;

DROP TABLE IF EXISTS usuarios_roles;
CREATE TABLE usuarios_roles(
	id_usuario INT NOT NULL,
	id_rol INT NOT NULL
);

DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios(
	id INT NOT NULL IDENTITY(1,1),
	username VARCHAR(50) NOT NULL,
	password VARCHAR(80) NOT NULL
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
	id INT NOT NULL IDENTITY(1,1),
	nombre VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS categorias;
CREATE TABLE categorias(
	id INT NOT NULL IDENTITY(0,1),
	nombre VARCHAR(60) NOT NULL,
	descripcion VARCHAR(60)
);

DROP TABLE IF EXISTS productos;
CREATE TABLE productos(
	id INT NOT NULL IDENTITY(1,1),
	nombre VARCHAR(60) NOT NULL,
	descripcion VARCHAR (80),
	precio DECIMAL(19,4) DEFAULT 0.0000,
	stock INT DEFAULT 0,
	id_categoria INT NOT NULL,
);

DROP TABLE IF EXISTS proveedor;
CREATE TABLE proveedor(
	id INT NOT NULL IDENTITY(1,1),
	nombre VARCHAR(60) NOT NULL,
	telefono VARCHAR (20)
);

DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes(
	id INT NOT NULL,
	nombre VARCHAR (60) NOT NULL,
	apellidos VARCHAR (60) NOT NULL,
	fecha_alta DATE NOT NULL,
	domicilio VARCHAR(80)
);

DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos(
	id INT NOT NULL,
	fecha date NOT NULL,
	total DECIMAL(19,4) NOT NULL,
	id_usuario INT NOT NULL,
	id_cliente INT NOT NULL
);

DROP TABLE IF EXISTS pedidos_productos;
CREATE TABLE pedidos_productos(
	id_pedido INT NOT NULL,
	id_producto INT NOT NULL,
	cantidad INT NOT NULL
);

DROP TABLE IF EXISTS entradas;
CREATE TABLE entradas(
	id INT NOT NULL,
	fecha DATE NOT NULL,
	id_usuario INT NOT NULL,
	id_proveedor INT
);

DROP TABLE IF EXISTS entradas_productos;
CREATE TABLE entradas_productos(
	id_entrada INT NOT NULL,
	id_producto INT NOT NULL,
	cantidad INT
);

ALTER TABLE usuarios ADD CONSTRAINT PK_usuario PRIMARY KEY (id);

ALTER TABLE roles ADD CONSTRAINT PK_rol PRIMARY KEY (id);

ALTER TABLE usuarios_roles ADD CONSTRAINT PK_usuarios_roles PRIMARY KEY (id_usuario, id_rol);
ALTER TABLE usuarios_roles ADD CONSTRAINT FK_usuarios_roles_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id);
ALTER TABLE usuarios_roles ADD CONSTRAINT FK_usuarios_roles_rol FOREIGN KEY (id_rol) REFERENCES roles (id);

ALTER TABLE categorias ADD CONSTRAINT PK_categoria PRIMARY KEY (id);

ALTER TABLE proveedor ADD CONSTRAINT PK_proveedor PRIMARY KEY (id);

ALTER TABLE productos ADD CONSTRAINT PK_producto PRIMARY KEY (id);
ALTER TABLE productos ADD CONSTRAINT FK_categoria FOREIGN KEY (id_categoria) REFERENCES categorias (id);

ALTER TABLE clientes ADD CONSTRAINT PK_cliente PRIMARY KEY (id);

ALTER TABLE pedidos ADD CONSTRAINT PK_pedido PRIMARY KEY (id);
ALTER TABLE pedidos ADD CONSTRAINT FK_pedido_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id);
ALTER TABLE pedidos ADD CONSTRAINT FK_pedido_cliente FOREIGN KEY (id_cliente) REFERENCES clientes (id);

ALTER TABLE pedidos_productos ADD CONSTRAINT PK_pedidos_productos PRIMARY KEY (id_pedido, id_producto);
ALTER TABLE pedidos_productos ADD CONSTRAINT FK_pedidos_productos_pedido FOREIGN KEY (id_pedido) REFERENCES pedidos (id);
ALTER TABLE pedidos_productos ADD CONSTRAINT FK_pedidos_productos_producto FOREIGN KEY (id_producto) REFERENCES productos (id);

ALTER TABLE entradas ADD CONSTRAINT PK_entrada PRIMARY KEY (id);
ALTER TABLE entradas ADD CONSTRAINT FK_entrada_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id);
ALTER TABLE entradas ADD CONSTRAINT FK_entrada_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor (id);

ALTER TABLE entradas_productos ADD CONSTRAINT PK_entradas_productos PRIMARY KEY (id_entrada, id_producto);
ALTER TABLE entradas_productos ADD CONSTRAINT FK_entradas_productos_entrada FOREIGN KEY (id_entrada) REFERENCES entradas (id);
ALTER TABLE entradas_productos ADD CONSTRAINT FK_entradas_productos_producto FOREIGN KEY (id_producto) REFERENCES productos (id);


INSERT INTO roles (nombre) VALUES('ROLE_ADMINISTRADOR'),('ROLE_INVENTARIOS'),('ROLE_GENERAL');

INSERT INTO categorias (nombre, descripcion) VALUES ('Sin Categoria', ''),('Abarrotes',''), ('Enlatados',''), ('Lacteos',''), 
('Botanas',''), ('Dulceria',''), ('Harinas',''), ('Frutas y verduras',''), ('Bebidas',''), 
('Bebidas alcoholicas',''), ('Alimentos preparados',''), ('Enlatados',''), ('Carnes y embutidos',''), 
('Automedicación',''), ('Higiene personal',''), ('Enlatados',''), ('Uso domestico',''), ('Helados',''), 
('Productos de limpieza',''), ('Enlatados',''), ('Otros','');

INSERT INTO proveedor (nombre, telefono) VALUES ('ACME Entregas ', '833-268-0332');

INSERT INTO usuarios (username, password) VALUES 
('general', '$2y$12$lEr8hmQ9wriGIjmtK.zZdujOEbELhsUDOf0XBzE4fbI1GIo1HE9Pm'),
('inventarios', '$2y$12$14SQuvr8lXBxeCzkZZxhKuJw8bojUVuIvr/NMEbitGfBfynI.fAC6'),
('administrador', '$2y$12$E2VR8LhTwJZyORMPzOAvgeRPOWCiJLPmSfhM5gxwAefDsr2R/h0R6');

INSERT INTO usuarios_roles (id_usuario, id_rol) VALUES (1,3), (2,2), (3,1);

INSERT INTO productos (nombre, descripcion, precio, stock, id_categoria) VALUES ('producto de prueba', 'producto de prueba', 10.00, 5, 2);