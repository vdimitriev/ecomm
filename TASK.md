# 🚀 Propeller Backend Assignment

This backend assignment's main goal is to test your ability to build a simple test `e-commerce` `GraphQL` `API`
using `JS/TS` and `Node.js` (other languages are fine as well!).

Main goal is to provide a single endpoint like `http://localhost/graphql` that will serve both `products` and `images`
data.

## Description

We are building a simple `e-commerce` API that will serve `products` and `images`. The API will be used by multiple
frontend applications that will display the `products` and `images`. The API should be able to serve the data in a way
that is easy to consume by the frontend applications.

You are free to use any libraries or frameworks to achieve the goal. We are using `NestJS` and `TypeORM` in our
projects, so it would be nice if you could use them as well. But if you are more comfortable with other libraries or
frameworks feel free to use them. Also feel free to use any database and ORM of your choice.

## Basic Minimal Models

### Product

Every product must have a `name`, `price` and `status`. Status can be active or inactive. A product can have 0 or
multiple images.

### Image

Every image must have a `url` and `priority` (min: 1, max: 1000, default: 100). An image can be associated with a
product.

`NOTE:` please assume that the `url` is a valid url to an image hosted on a CDN or a file server,
[for example](https://images.unsplash.com/photo-1615789591457-74a63395c990?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80)

## Requirements

1. Implement CRUD `queries`/`mutations` for the models using best practices with at least some filtering on
   the `queries`
2. Build the GraphQL API for serving `products` and build a separate api for serving `images`, then connect
   the two APIs together using GraphQL federation (Apollo Federation v2) or schema stitching

### Bonus Points

- Create `docker-compose.yml` for running the `APIs` and `DB` locally
- Implement `CI/CD` pipeline for test, build and deployment (Gitlab, Github Actions etc.)
- Be mindful of naming conventions & guides, software development principles and clean code

## Submission

Please deliver this **as you would an application *ready for production*, using all the best practices you normally
follow** while keeping in mind performance as well.
The source code can be shared via any online Git repository.