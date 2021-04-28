<!--  -->
<template>
  <div class="x-nine mar" style="margin-top: 5%;">
    <div class="x-ten df" style="height: 550px;">
      <div class="x-three df grey xy-center">
        <img
          :src= flower.image
          alt=""
          class="x-nine y-eight"
          style=""
        />
      </div>
      <div class="x-sixfive mar">
        <h1 style="color:#4F4F4F;">{{flower.name}}</h1>
        <el-divider></el-divider>
        <div class="df" style="aligin-item:center;">
          <div v-for="(item,index) in flower.stars" :key="index">
            <i class="el-icon-star-on" style="color:orange;font-size:20px;"></i>
          </div>
          <div v-for="index1 in 5-flower.stars" :key="index1">
              <i class="el-icon-star-off" style="color:grey;font-size:16px;"></i>
          </div>
          <div class="" style="color:#B5B5B5;font-size:15px;">{{flower.stars}} Review(s) | write a review</div>
        </div>
        <div class="df" style="height:45px;font-size:20px;">
          <div class="xy-center">${{flower.specialPrice}}</div>
          <del style="color:#B5B5B5;">${{flower.marketPrice}}</del>
        </div>
        <div style="height:30px;">Item Code: #{{flower.flowerId}}</div>
        <div style="height:30px;">Availability:In stock</div>
        <div style="height:20px;">Condition:New</div>
        <el-divider></el-divider>
        <div class="">
          {{flower.description}}
        </div>
        <el-divider></el-divider>
        <div>
          <div style="font-weight: bold;">Available Options:</div>
          <div style="margin-top:20px;">
            Qty：
            <el-button style="font-size:20px;">-</el-button>
            1
            <el-button style="font-size:20px;">+</el-button>
            <el-button style="background-color:#e62263;color:white;font-weight: bold;">ADD TO CART</el-button>
            <el-button><i class="el-icon-star-on" style="font-size:20px;"></i></el-button
            ><el-button><i class="el-icon-s-data" style="font-size:20px;"></i></el-button>
          </div>
        </div>
        <el-divider></el-divider>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      flowerId:'',
      flower: ''
    }
  },

  components: {},

  computed: {},

  mounted() {},

  methods: {
    getFlowerId(){
      this.flowerId = this.$route.query.id
      this.getFlower()

    },
    getFlower(){
      this.axios({
        method: 'post',
        url: this.GLOBAL.BASE_URL + 'flower/getOneByFlowerId',
        params: {
          flowerId: this.flowerId
        }
      }).then((res) => {
        if(res.data.code === 1) {
          this.flower = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'flower/getOneByFlowerId'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
      })
    }
  },
  created() {
    this.getFlowerId()
  }
}
</script>
<style lang="scss" scoped>
.f {
  font-weight: bold;
}
</style>
