import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Pantalla Inicio"),
        backgroundColor: Colors.indigo,
        centerTitle: true,
        actions: const [
          Icon(Icons.settings),
          SizedBox(width: 12,),
          Icon(Icons.add),
        ],
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16,),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text(
                "Bienvenido a mi aplicación personal",
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.indigo,
                ),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 30),
              ElevatedButton(
                onPressed: () {},
                child: const Text("Ver mi perfil"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}