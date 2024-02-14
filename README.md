# Personal Webpage using Compose for Web

This repository contains the code for my personal webpage built using Compose for Web, specifically leveraging Compose Web Canvas.

The webpage is live and hosted at [saler.nu](https://saler.nu).

## How to run the project

The project can be run locally or built for deployment using the following commands:

### Run the project locally
`./gradlew jsBrowserDevelopmentRun`

### Build the project for deployment
`./gradlew jsBrowserProductionWebpack`

## Questions & Answers

### Why Compose for Web with Javascript over Wasm/JS?

There are two main reasons behind choosing Compose for Web with Javascript instead of Wasm/JS:
1. **Availability of Third-Party Libraries**: Compose for Web offers a wider range of third-party libraries compared to Wasm/JS alternatives.
2. **Broader Browser Support**: Unlike Kotlin/WASM, which requires WASM GC (Garbage Collection) that isn't yet available in Safari and requires opt-in for Firefox and Chrome, Compose with Javascript offers better browser compatibility.

### Why Compose Instead of HTML and CSS?

Although this webpage could have been created using HTML and CSS, I opted for Compose due to the following reasons:
1. **Preference for Kotlin**: I have a strong affinity for Kotlin as it is an easy-to-use language, and I possess more proficiency in it compared to CSS and HTML.
2. **Exploration and Experimentation**: Compose offers extensive potential for multiplatform use, even though this project does not utilize it. Exploring Compose for Web allows me to assess its potential and envision potential applications for future clients.

### Could the Webpage Be Implemented Using HTML?

Yes, definitely. Creating the webpage using HTML and CSS would have been simpler. However, I chose to implement it using Compose for Web primarily to explore its capabilities and leverage my familiarity with Kotlin.

## Screenshots

Here is a screenshot of the web page:

![screenshot.png](screenshot.png)

---
*Note: Feel free to explore the code, provide feedback, or contribute if you find any improvements or suggestions.*


