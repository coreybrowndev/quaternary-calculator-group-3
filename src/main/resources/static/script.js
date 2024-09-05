

const buttons = document.querySelectorAll(".key")

const display = document.querySelector("#display")

const Operations = Object.freeze({
    ADD:  {value: "ADD", op: '+'},
    SUBTRACT:  {value: "SUBTRACT", op: '-'},
    MULTIPLY: {value: "MULTIPLY", op: '*'},
    DIVIDE: {value: "DIVIDE", op: '/'},
});

let operand1 = ""
let operand2 = ""
let op = ""
let operation = null
let base = 4


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
        "base": base
    }

    let calculation = await computeResult(payload)

    //make the ajax request and then return the result and place into the display

    display.placeholder += ` ${calculation.result}`

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
            console.log("Error: Failed to fetch calculation result.");
            return;
        }

        const results = await response.json();
        return results;
    }catch (error) {
        if (error instanceof Error) {
            console.log("Error when performing calculation: ", error.message)
        }
        console.log("Unknown error occured when calculating: ", error)
    }
}
