

const buttons = document.querySelectorAll(".key")

const display = document.querySelector("#display")

const baseButton = document.querySelector(".base")

const Operations = Object.freeze({
    ADD:  {value: "ADD", op: '+'},
    SUBTRACT:  {value: "SUBTRACT", op: '-'},
    MULTIPLY: {value: "MULTIPLY", op: '*'},
    DIVIDE: {value: "DIVIDE", op: '/'},
    SQUARE: {value: "SQUARE", op: 'a ²'},
    SQUARE_ROOT: {value: "SQUARE_ROOT", op: '√'},
    TOGGLE: {value: "TOGGLE"}
});

let operand1 = ""
let operand2 = ""
let op = ""
let operation = null
let base = 4
let x = -10000000
let calculationResultFromPreviousRequest;



function appendNumber(digit) {
    //keep appending digit until there is a operator set

    if (!op) {
        operand1 += digit
    }else {
        operand2 += digit
    }

    display.placeholder = `${operand1} ${op} ${operand2}`
}

function setOperation(symbol) {
    const o = Object.values(Operations).find((o) => o.op === symbol)
    operation = o.value
    if (operation === Operations.SQUARE.value) {
        display.placeholder = `${operand1} ²`
    }

    if (operation === Operations.SQUARE_ROOT.value) {
        display.placeholder = `√${operand1}`
    }

    if (!operand1) return

    if(o) {
        op = o.op
    }
}

function clearDisplay() {
    operand1 = ""
    operand2 = ""
    op = ""
    display.placeholder = ""
}

async function calculate() {
    display.placeholder += " ="

    let payload = {
        "operand1": operand1,
        "operand2": operand2,
        "operation": operation,
        "base": base,
        "x" : x
    }

    if(operand2 === "" && operand1.length > 0) {
        payload["x"] = operand1
    }

    let calculation = await computeResult(payload)

    calculationResultFromPreviousRequest = calculation.result

    display.placeholder += ` ${calculation.result} `
}

async function toggleBase() {
    const currentBase = base
    operation = Operations.TOGGLE

    let payload = {
        "operand1": operand1,
        "operand2": operand2,
        "operation": operation.value,
        "base": base,
        "x" : x,
        "result": calculationResultFromPreviousRequest
    }

    try {

        const calculation = await computeResult(payload)
        calculationResultFromPreviousRequest = calculation.result

        if (currentBase === 4) {
            base = 10;
        } else {
            base = 4
        }



        display.placeholder = `${calculation.result}`
        baseButton.innerHTML = `Base ${currentBase}`

    } catch (error) {
        if (error instanceof Error) {
            display.placeholder = "undefined"
            console.log("Error processing conversion: ", error.message)
        }
        display.placeholder = "undefined"
        console.log("Uknown error when processing conversion request: ", error)
    }

    console.log('our base: ', base)

    //else convert to 4
}

async function computeResult (payload) {
    const apiUrl = "http://localhost:8080/calculate"

    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload)
        });

        if(!response.ok) {
            display.placeholder = "undefined"
            console.log("Error: Failed to fetch calculation result.");
            return;
        }

        const results = await response.json();
        return results;
    }catch (error) {
        if (error instanceof Error) {
            display.placeholder = "undefined"
            console.log("Error when performing calculation: ", error.message)
        }
        display.placeholder = "undefined"
        console.log("Unknown error occured when calculating: ", error)
    }
}
