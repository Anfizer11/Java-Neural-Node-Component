# Java Neural Node Component

A reusable Java software component that models the basic behavior of an
artificial neuron through weighted inputs, signal processing, normalized
outputs, and threshold-based activation.

## Overview

This project was created as an open-ended bonus assignment for a software
development course(Software II CSE 2231). The assignment required designing an original software
component based on an object or concept from the real world or computer
science.

I chose to model a simplified artificial neuron. No component interface,
method definitions, or implementation structure were provided. I designed
the component's API, representation, contracts, and behavior independently.

The resulting component stores input signals and their associated weights,
processes the weighted values, calculates a normalized output, and determines
whether a node activates based on a configured threshold.

## Features

- Stores signal and weight pairs
- Adds and removes input signals
- Configures an activation threshold
- Processes weighted input values
- Calculates the sum of processed signals
- Produces a normalized node output
- Evaluates threshold-based activation
- Provides standard `toString` and `equals` behavior
- Uses preconditions and postconditions to document component behavior

## Object-Oriented Design

The component follows a layered design consisting of four Java types.

### `NodeKernel`

Defines the fundamental operations required to manage the node's internal
state, including signal-weight pairs, threshold configuration, and input
processing.

### `Node`

Extends the kernel interface with higher-level operations such as signal
summation, output calculation, and activation evaluation.

### `NodeSecondary`

Provides reusable implementations of the secondary methods and standard
object methods shared by concrete node representations.

### `Node1`

Provides the concrete representation of the component and implements the
kernel operations.

```text
NodeKernel
    ↑
  Node
    ↑
NodeSecondary
    ↑
  Node1
```

This structure separates the public interface, reusable behavior, and
representation-specific implementation.

## Workflow

The component follows this general workflow:

1. Create a node.
2. Add input signals and their corresponding weights.
3. Configure the activation threshold.
4. Process each signal-weight pair.
5. Calculate the node's normalized output.
6. Compare the output with an activation threshold.


Example:

```java
Node node = new Node1();

node.addSignalPair(0.8, 0.5);
node.addSignalPair(0.4, 0.7);
node.addSignalPair(0.6, 0.9);

node.setThreshold(0.65);
node.processAllSignalPairs();

double output = node.getAxon();
System.out.println("Node output: " + output);
```

## Design by Contract

The methods include documented preconditions and postconditions describing
their expected behavior.

Examples include:

- Signals may only be added or removed before processing.
- Threshold values must remain between `0.0` and `1.0`.
- Output calculations require processed signal pairs.
- Activation checks require a valid node and processed inputs.

Java assertions are used to detect violations of these requirements during
development.

## Technologies and Concepts

- Java
- Object-oriented programming
- Interfaces and abstract classes
- Inheritance and polymorphism
- Encapsulation
- Data abstraction
- Design by contract
- Java assertions
- API design
- Technical documentation
- Sequence and map components

## Project Structure

```text
java-neural-node-component/
├── README.md
├── .gitignore
└──  src/
     └── NodeUtility/
        ├── Node.java
        ├── NodeKernel.java
        ├── NodeSecondary.java
        └── Node1.java
```

## Dependencies

The original implementation uses the Ohio State CSE Components library,
including its `Sequence` and `Map` components.

The library must be available on the Java classpath to compile the original
course implementation.

## Project Context

This project was completed as an optional bonus assignment for a Software II
course. The prompt required independently designing an object-oriented
component representing a real-world object or computer science concept.

This project is an educational abstraction inspired by an artificial neuron.
It is intended to demonstrate component design and object-oriented
programming rather than serve as a production neural-network implementation.
