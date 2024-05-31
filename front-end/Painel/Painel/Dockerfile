# Use Node.js to build and serve the application
FROM node:18-alpine
WORKDIR /app
COPY . .
RUN npm install

# Set environment variable for Vite port
ENV VITE_PORT=5174

# Expose the port
EXPOSE 5174

# Run Vite on the specified port
CMD ["npx", "vite", "--host", "0.0.0.0", "--port", "5174"]
