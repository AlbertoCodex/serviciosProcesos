

# Created on : Oct 2, 2023, 8:09:04 PM
# Author     : Alberto


# This is a sample Python script.

# Press Shift+F6 to execute it or replace it with your code.

import json
import sys

def bucle(valor1, valor2):
    manolito=valor1+valor2
    print("El resultado de la suma es:",manolito)

pelicula = { "El resplandor":
    {
        "Director":"Kubrick",
        "año":1980,
        "Reparto":[
            {"Nombre":"Jack Nicholson"},
            {"Nombre":"Shelley Duval"},
            {"Nombre":"DannyLloyd"},
            {"Nombre":"Scatman"},
        ]
    }
}
bucle(4,5)
print(json.dumps(pelicula))
sys.exit(0)