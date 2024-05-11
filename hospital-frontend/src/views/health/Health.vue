<template>
  <div>
    <p>{{ time }}</p>
  </div>
</template>

<script>
export default {
  name: "Health",
  data() {
    return {
      time: '',
      timerId: null
    };
  },
  created() {
    this.startClock();
  },
  methods: {
    startClock() {
      this.timerId = setInterval(() => {
        const now = new Date();
        this.time = now.toLocaleTimeString(); // 更新时间
      }, 1000); // 每秒更新一次
    },
    clearClock() {
      if (this.timerId) {
        clearInterval(this.timerId);
        this.timerId = null;
      }
    }
  },
  beforeDestroy() {
    this.clearClock(); // 清除定时任务
  }
};
</script>