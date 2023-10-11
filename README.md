# SocketChat

# Proyecto de la asignatura Programación en Ambiente Cliente - Servidor

Consiste en un chat local que funciona mediante sockets, el programa permite elegir si el usuario quiere ser servidor o cliente.
En caso de ser servidor se marca la casilla "Soy servidor" y el programa espera a que un cliente se conecte.
Una vez conectado el servidor, el cliente puede acceder, desmarcando la casilla "Soy servidor" se habilita el campo de IP (del servidor).
Una vez se completan los pasos se le permite a los usuarios enviar y recibir mensajes.

Es posible guardar y cargar la conversación desde un archivo almacenable en disco y maneja excepciones varias de conexión.

Algunas funciones están incompletas o no disponibles.

# Función de cifrado

Se agregó una función que cifra los mensajes enviados entre cliente-servidor.

Como demostración en el área principal se muestra la comunicación con texto llano (sin cifrar), y en el área derecha se muestran los mensajes enviados/recibidos cifrados, es decir, pueden verse los mensajes tal como viajan en el socket y que se cifran (cuando se envía) o se descifran (cuando se recibe).
