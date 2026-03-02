## Ant Track Spring Boot

Aplicación de seguimiento de gastos hormiga desarrollada en Spring Boot.

## Descripción
Permite a los usuarios registrar y categorizar sus gastos pequeños del día a día,
con alertas y control de presupuesto mensual.

## Entidades
- **Usuario** → usuario de la aplicación
- **Categoria** → agrupa los gastos por tipo
- **Gasto** → registro de cada gasto realizado
- **Comercio** → lugar donde se realizó el gasto
- **MetodoPago** → forma de pago utilizada

## Relaciones
- Un Usuario tiene muchas Categorias
- Un Usuario tiene muchos Gastos
- Un Gasto pertenece a una Categoria, un Comercio y un MetodoPago

## Tecnologías
- Java 17
- Spring Boot
- JPA / Hibernate
- MySQL

## Flujo de trabajo
- Rama principal: `main`
- Rama de desarrollo: `develop`
- Ramas por integrante: `feat-nombre`

