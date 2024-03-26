import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Stateful example"),
        ),
        body: Center(
          child: Text('Voce clicou $counter vezes'),
        ),
        floatingActionButton: FloatingActionButton(
            onPressed: () {
              setState(() {
                counter += 1;
              });
            },
            child: const Icon(Icons.add)),
      ),
    );
  }
}
