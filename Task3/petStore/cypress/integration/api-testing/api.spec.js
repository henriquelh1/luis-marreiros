/// <reference types="cypress" />

import pet1 from '../../fixtures/pet1.json'
import order from '../../fixtures/order.json'
import orderInvalid from '../../fixtures/order-invalid.json'
import user from '../../fixtures/user.json'

describe("Api Testing", () => {

    const baseURL = "http://localhost/v2";

    it("Should show the name of the Pets available", () => {
        cy.request({
            method: "GET",
            url: baseURL+"/pet/findByStatus?status=available",
            headers: {
                accept: "application/json"
            }
        }).then(resp => {
            expect(resp.status).to.eq(200)
            expect(resp.duration).to.not.be.greaterThan(1500) 
            resp.body.forEach(function(item) {   
                    cy.log(item.name)
            });
        })
    })

    it("Should add new pet", () => {
        cy.request({
            method: "POST",
            url: baseURL+"/pet",
            body:pet1
        }).then(resp => {
            expect(resp.status).to.eq(200)
            cy.log(resp.name)
            expect(resp.body.name).to.eq("doggie") 
        })
    })

    it("Should update pet info", () => {
        cy.request({
            method: "PUT",
            url: baseURL+"/pet/"+pet1.id,
            body:pet1
        }).then(resp => {
            expect(resp.status).to.eq(200)
            cy.log(resp.name)
            expect(resp.body.name).to.eq("Lulu") 
            expect(resp.body.status).to.eq("sold") 
        })
    })
    
    it("Should place an order for a pet", () => {
        cy.request({
            method: "POST",
            url: baseURL+"/store/order",
            body:order
        }).then(resp => {
            expect(resp.status).to.eq(200)
            expect(resp.body.status).to.eq("approved") 
            expect(resp.body.complete).to.eq(true) 
        })
    })

    it("Should not search for an inexistent order", () => {
        cy.request({
            method: "GET",
            failOnStatusCode: false,
            url: baseURL+"/store/order/982727277298"
            
        }).then(resp => {
            expect(resp.status).to.eq(404)
            expect(resp.body.message).to.eq("Order not found") 
        })
    })

    it("Should create user", () => {
        cy.request({
            method: "POST",
            url: baseURL+"/user",
            body:user
        }).then(resp => {
            expect(resp.status).to.eq(200)
        })
    })

    it("Should login with user credentials", () => {
        cy.request({
            method: "GET",
            url: baseURL+"/user/login",
            body:{"username": user.username, "password":user.password}
        }).then(resp => {
            expect(resp.status).to.eq(200)
            expect(resp.body.message).contains("logged in user session:")
        })
    })
    
    it("Should delete user", () => {
        cy.request({
            method: "DELETE",
            url: baseURL+"/user/"+user.username,
        }).then(resp => {
            expect(resp.status).to.eq(200)
        })
    })

    it("Check pending orders", () => {
        cy.request({
            method: "GET",
            url: baseURL+"/store/inventory",
        }).then(resp => {
            expect(resp.body.pending).to.eq(2)
        })
    })

    it("Should not delete inexistent order", () => {
        cy.request({
            method: "DELETE",
            url: baseURL+"/store/order/"+orderInvalid.id,
        }).then(resp => {
            expect(resp.status).to.eq(404)
            expect(resp.body.message).to.eq("Order not found") 
        })
    })
})
