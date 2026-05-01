DROP DATABASE IF EXISTS component_stock_db;

CREATE DATABASE component_stock_db
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE component_stock_db;

-- 1. 管理员表
CREATE TABLE admin (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(30) NOT NULL UNIQUE,
                       password VARCHAR(30) NOT NULL,
                       real_name VARCHAR(30)
);

-- 2. 元器件分类表
CREATE TABLE category (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          category_name VARCHAR(50) NOT NULL,
                          remark VARCHAR(100)
);

-- 3. 存放位置表
CREATE TABLE storage_location (
                                  id INT PRIMARY KEY AUTO_INCREMENT,
                                  cabinet_type VARCHAR(10) NOT NULL,
                                  column_code VARCHAR(5) NOT NULL,
                                  layer_no INT NOT NULL,
                                  grid_no INT NOT NULL,
                                  side_code VARCHAR(5) NOT NULL,
                                  location_code VARCHAR(30) NOT NULL UNIQUE,
                                  remark VARCHAR(100)
);

-- 4. 元器件信息表
CREATE TABLE component (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           component_code VARCHAR(30) NOT NULL UNIQUE,
                           name VARCHAR(50) NOT NULL,
                           category_id INT,
                           model VARCHAR(50),
                           package_type VARCHAR(50),
                           quantity INT DEFAULT 0,
                           min_quantity INT DEFAULT 0,
                           location_id INT,
                           remark VARCHAR(100),
                           FOREIGN KEY (category_id) REFERENCES category(id),
                           FOREIGN KEY (location_id) REFERENCES storage_location(id)
);

-- 5. 入库记录表
CREATE TABLE in_record (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           component_id INT NOT NULL,
                           in_quantity INT NOT NULL,
                           operator_name VARCHAR(30),
                           in_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                           remark VARCHAR(100),
                           FOREIGN KEY (component_id) REFERENCES component(id)
);

-- 6. 出库记录表
CREATE TABLE out_record (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            component_id INT NOT NULL,
                            out_quantity INT NOT NULL,
                            receiver VARCHAR(30),
                            purpose VARCHAR(100),
                            out_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                            remark VARCHAR(100),
                            FOREIGN KEY (component_id) REFERENCES component(id)
);

-- 插入管理员测试数据
INSERT INTO admin(username, password, real_name)
VALUES ('admin', '123456', '管理员');

-- 插入元器件分类测试数据
INSERT INTO category(category_name, remark)
VALUES
    ('电阻类', '各类固定电阻、可调电阻'),
    ('电容类', '贴片电容、电解电容等'),
    ('芯片类', '单片机、逻辑芯片、驱动芯片'),
    ('传感器类', '温湿度、红外、光敏等传感器'),
    ('模块类', '蓝牙、WiFi、继电器等模块'),
    ('连接器类', '排针、端子、杜邦线等连接器件');

-- 插入存放位置测试数据
INSERT INTO storage_location
(cabinet_type, column_code, layer_no, grid_no, side_code, location_code, remark)
VALUES
    ('T1', 'A', 1, 1, 'F', 'T1-A01-1F', '第1类柜子A列1层1格前格'),
    ('T1', 'A', 1, 2, 'B', 'T1-A01-2B', '第1类柜子A列1层2格后格'),
    ('T1', 'B', 2, 3, 'F', 'T1-B02-3F', '第1类柜子B列2层3格前格'),
    ('T2', 'A', 1, 1, 'F', 'T2-A01-1F', '第2类柜子A列1层1格前格'),
    ('T2', 'B', 3, 4, 'B', 'T2-B03-4B', '第2类柜子B列3层4格后格'),
    ('T3', 'C', 2, 1, 'B', 'T3-C02-1B', '第3类柜子C列2层1格后格');

-- 插入元器件测试数据
INSERT INTO component
(component_code, name, category_id, model, package_type, quantity, min_quantity, location_id, remark)
VALUES
    ('R-001', '电阻', 1, '10KΩ', '0603', 500, 50, 1, '常用贴片电阻'),
    ('C-001', '电容', 2, '100uF', '直插', 100, 20, 2, '电解电容'),
    ('IC-001', 'STM32单片机', 3, 'STM32F103C8T6', 'LQFP48', 10, 5, 3, '常用主控芯片'),
    ('S-001', '温湿度传感器', 4, 'DHT11', '模块', 15, 5, 4, '实验常用传感器'),
    ('M-001', '蓝牙模块', 5, 'HC-05', '模块', 8, 3, 5, '串口蓝牙模块'),
    ('J-001', '杜邦线', 6, '母对母', '20cm', 30, 40, 6, '库存偏低测试数据');

-- 插入入库记录测试数据
INSERT INTO in_record(component_id, in_quantity, operator_name, remark)
VALUES
    (1, 100, '管理员', '电阻补充入库'),
    (2, 50, '管理员', '电容补充入库');

-- 插入出库记录测试数据
INSERT INTO out_record(component_id, out_quantity, receiver, purpose, remark)
VALUES
    (3, 2, '张三', '单片机实验', '领取STM32芯片'),
    (5, 1, '李四', '蓝牙通信实验', '领取蓝牙模块');