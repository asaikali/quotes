<template>
  <div>
    <p v-if="message">{{ message }}</p>
    <p v-else>Loading message...</p>
  </div>
</template>

<script>
export default {
  name: 'Billboard',
  data() {
    return {
      message: '',
      intervalId: null // To store the interval ID
    };
  },
  mounted() {
    this.fetchMessage(); // Fetch immediately on mount
    this.intervalId = setInterval(this.fetchMessage, 3000); // Set up the interval
  },
  beforeUnmount() {
    if (this.intervalId) {
      clearInterval(this.intervalId); // Clear the interval on component unmount
    }
  },
  methods: {
    fetchMessage() {
      fetch('/api/message-service/')
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.text();
          })
          .then(data => {
            this.message = data;
          })
          .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            this.message = 'Failed to load message';
          });
    }
  }
};
</script>

<style scoped>
/* Add your styles here */
</style>
