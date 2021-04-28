<template>
  <div>
    <!-- 首部 -->
    <div class="top df x-ten border-grey" style="font-size: 14px;">
      <div class="top1 x-three df xy-center">
        <div class="top-1 x-seven">FlowerShop!</div>
      </div>
      <div class="x-two df"></div>
      <div class="top2 x-three mar df xy-center">
        <div class="top-1 x-onetwo" >账户</div>
        <div class="top-1 x-onetwo">心愿单</div>
        <div class="top-1 x-onetwo">检查</div>
        <div class="top-1 x-onetwo">更多</div>
        <div class="top-1 x-onetwo">登录</div>
      </div>
    </div>
    <!-- logo和search -->
    <div class="df x-nine" style="justify-content: flex-end;margin-top: 1%;">
      <div class="x-five xy-center" style="height: 70px;margin-right: 2%;">
        <img src="https://i.loli.net/2021/04/15/neb1lXPW8arJc59.jpg" class="x-five y-ten" alt="11" />
      </div>
      <div class="x-two xy-center">
        <el-input placeholder="请输入内容" clearable prefix-icon="el-icon-search" v-model="input2"></el-input>
      </div>
    </div>
    <!-- 主要内容 -->
    <div>
      <el-tabs :tab-position="tabPosition" stretch class="x-nine mar">
        <el-tab-pane label="Home" >
          <!-- 顶部轮播图 -->
          <div class="img-ll" >
            <el-carousel indicator-position="outside"  style="height:500px;">
              <el-carousel-item v-for="(item,index) in slides" :key="index"  style="height:500px;">
                <img :src="item.src" alt class="x-ten y-ten"  style="height:500px;"/>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div style="width: 80%;" class="mar">
            <!-- 中间三件特殊商品 -->
            <div class="df mar-top">
              <div class="x-three y-nine mar" v-for="(item,index) in jtvBanners" :key="index" >
                <img :src="item.src" alt class="x-ten y-ten" />
              </div>
            </div>
            <div class="f-2 x-ten">
              <!-- Best Seller -->
              <div class="f-2-title x-ten mar-top font-bestSeller" >Best Seller</div>
              <div class="f-2-content">
                <el-tabs :tab-position="tabPosition" stretch class="x-ten mar" v-model="meaningCategoryId" @tab-click="getMeaningList">
                  <el-tab-pane
                    :label="item.name"
                    style="height: 350px;"
                    v-for="(item,index) in meaningNameList.slice(0,5)"
                    :key="index"
                    :name="item.meaningCategoryId"
                    class="x-ten df"                    
                  >
                    <div class="mar font51" style="width: 18%;height: 100%;" v-for="(flower,index1) in meaningList" :key="index1">
                      <div class="y-six" @click="toDetail(flower.flowerId)">
                        <img :src="flower.image" alt class="x-ten y-ninefive xy-center" />
                      </div>
                      <div class="y-four text-center">
                        <div class="f-title y-twofive xy-center">{{flower.name}}</div>
                        <div class="f-x y-twofive xy-center">
                        <div v-for="index in flower.stars" :key="index">
                            <i class="el-icon-star-off" style="color:rgb(230, 34, 99)"></i>
                        </div>
                        <div v-for="index in 5-flower.stars" :key="index">
                            <i class="el-icon-star-off" style="color:rgb(197, 197, 197)"></i>
                        </div>
                        </div>
                        <div style="display: flex;">
                        <div class="f-price y-twofive x-three" style="margin-left:50px;color: rgb(230, 34, 99);font-size: 14px;font-weight: bolder;">${{flower.marketPrice}}</div>
                        <del class="f-price y-twofive y-center" style="color:rgb(197, 197, 197);font-size: 11px;">${{flower.specialPrice}}</del>
                      </div>
                        <el-button plain size="medium">ADD TO CARE</el-button>
                      </div>
                    </div>
                  </el-tab-pane>
                </el-tabs>
              </div>

              <div class="f-3 df mar-top grey font51" style="height: 350px;padding-top: 1%;">
                <!-- 写死了的，卡片区域 -->
                <div class="x-seven bc-i" style="color: white;">
                  <div class="f-3-top text-center" style="font-size: 20px;padding-top: 10%;">Hot Product</div>
                  <div
                    class="f-3-intro x-eight mar-top"
                    style="line-height:2%;padding-top: 8%;font-size: 10px;margin: 0 auto;line-height:20px;"
                  >
                    JONQUIL - Love Me, Affection Returned, Desire, Sympathy, Desire For Affection Returned. DAFFODIL
                    -Regard, Unrequited Love, You're The Only One, The Sun Is Always Shining When I'm With You, Respect
                  </div>
                  <div class="text-center" style="padding-top: 8%;">
                    <el-button plain size="mini" style="color: #000000;">MORE PRODUCT</el-button>
                  </div>
                  
                  <div class="f-3-bot df x-nine mar padding" style="background-color: #df7ae6;margin-top: 15%;font-size: 12px;">
                    <div class="bot x-twofive">
                      <div class="text-center">874</div>
                      <div class="text-center">DAYS</div>
                    </div>
                    <div class="bot x-twofive">
                      <div class="text-center">20</div>
                      <div class="text-center">HRS</div>
                    </div>
                    <div class="bot x-twofive">
                      <div class="text-center">49</div>
                      <div class="text-center">MINS</div>
                    </div>
                    <div class="bot x-twofive">
                      <div class="text-center">06</div>
                      <div class="text-center">SECS</div>
                    </div>
                  </div>
                </div>

                <div class="x-eight df" v-for="(hotFlower,hotIndex) in hotList.slice(0,3)" :key="hotIndex">
                  <div class="mar" style="width: 65%;height: 100%;">
                    <div class="y-six" @click="toDetail(hotFlower.flowerId)">
                      <img
                        :src=hotFlower.image
                        alt
                        class="x-ten y-ninefive xy-center"
                      />
                    </div>
                    <div class="y-four text-center">
                      <div class="f-title y-twofive xy-center">{{hotFlower.name}}</div>
                      <div class="f-x y-twofive xy-center" >
                        <div v-for="starIndex in hotFlower.stars" :key="starIndex">
                            <i class="el-icon-star-off" style="color:rgb(230, 34, 99)"></i>
                        </div>
                        <div v-for="starIndex in 5-hotFlower.stars" :key="starIndex">
                            <i class="el-icon-star-off" style="color:rgb(197, 197, 197)"></i>
                        </div>
                      </div>

                      <div style="display: flex;">
                        <div class="f-price y-twofive x-three" style="margin-left:50px;color: rgb(230, 34, 99);font-size: 14px;font-weight: bolder;">${{hotFlower.marketPrice}}</div>
                        <del class="f-price y-twofive y-center" style="color:rgb(197, 197, 197);font-size: 11px;">${{hotFlower.specialPrice}}</del>
                      </div>
                      <el-button plain size="medium" style="margin-top:5%">ADD TO CARE</el-button>
                    </div>
                  </div>
                </div>
              </div>


              <!-- News Products -->
              <div class="text-center mar-top font-bestSeller" style="font-size: 20px;" >New Products</div>
              <div class="x-ten df mar-top" style="height: 350px;" >
                <div class="mar grey" style="width: 20%;height: 100%;" v-for="(newFlower,index) in newList.slice(0,4)" :key="index">
                  <div class="y-six" @click="toDetail(newFlower.flowerId)">
                    <img
                      :src=newFlower.image
                      alt
                      class="x-ten y-ninefive xy-center"
                    />
                  </div>
                  <div class="y-four text-center">
                    <div class="f-title y-twofive xy-center">{{newFlower.name}}</div>
                    <div class="f-x y-twofive xy-center">
                        <div v-for="index in newFlower.stars" :key="index">
                            <i class="el-icon-star-off" style="color:rgb(230, 34, 99)"></i>
                        </div>
                        <div v-for="index in 5-newFlower.stars" :key="index">
                            <i class="el-icon-star-off" style="color:rgb(197, 197, 197)"></i>
                        </div>
                    </div>
                    <div class="f-price y-twofive xy-center" style="color: #ff342a;font-size: 14px;">$155.00</div>
                    <el-button plain size="medium">ADD TO CARE</el-button>
                  </div>
                </div>
              </div>
              <!-- Testimonials -->
              <div class="text-center mar-top font-bestSeller" style="font-size: 22px;" >Testimonials</div>
              <div style="height: 280px;" class="grey x-ten mar-top">
                <div class="x-four df mar" style="height: 28%;margin-top: 5%;">
                  <div class="mar" style="width: 18%;">
                    <img
                      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA1l6wbQU2pQk2DVU9wTp8MyaiUKKpGZy34g&usqp=CAU"
                      alt
                      class="x-ten y-ten"
                    />
                  </div>
                  <div class="mar" style="width: 18%;">
                    <img
                      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA1l6wbQU2pQk2DVU9wTp8MyaiUKKpGZy34g&usqp=CAU"
                      alt
                      class="x-ten y-ten"
                    />
                  </div>
                  <div class="mar" style="width: 18%;">
                    <img
                      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA1l6wbQU2pQk2DVU9wTp8MyaiUKKpGZy34g&usqp=CAU"
                      alt
                      class="x-ten y-ten"
                    />
                  </div>
                  <div class="mar" style="width: 18%;">
                    <img
                      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA1l6wbQU2pQk2DVU9wTp8MyaiUKKpGZy34g&usqp=CAU"
                      alt
                      class="x-ten y-ten"
                    />
                  </div>
                  <div class="mar" style="width: 18%;">
                    <img
                      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQA1l6wbQU2pQk2DVU9wTp8MyaiUKKpGZy34g&usqp=CAU"
                      alt
                      class="x-ten y-ten"
                    />
                  </div>
                </div>
                <div class="ying mar-top paddingl" style="color: grey;line-height: 28px;">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididuntut labore et
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco consequat. Duis aute
                  irure dolor in reprehenderit in laboris nisi ut aliquip ex ea commodo m dolore eu fugiat nulla
                  pariatur.!9 voluptate velit esse cillu
                </div>
              </div>
              <!-- vfvv -->
              <div style="height: 50px;"></div>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="Shop Grid">Shop Grid</el-tab-pane>
        <el-tab-pane label="Single Product">Single Product</el-tab-pane>
        <el-tab-pane label="Love&Romance">Love&Romance</el-tab-pane>
        <el-tab-pane label="Occasion">Occasion</el-tab-pane>
        <el-tab-pane label="Flowers">Flowers</el-tab-pane>
        <el-tab-pane label="Sympathy">Sympathy</el-tab-pane>
        <el-tab-pane label="Blog">Blog</el-tab-pane>
        <el-tab-pane label="Specials">Specials</el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      input2: '',
      tabPosition: 'top',
      rows: [],
      slides: [],
      jtvBanners: [],
      meaningNameList: [],
      meaningList: [],
      typeName: 'meaning',
      meaningCategoryId: 'beba6dbf65fa4887a452b82991feee0e',
      hotList:[],
      newList:[]
    }
  },
  methods: {
    getSlides() {
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'cover/getCovers',
        params: {
          type: 'slide',
        },
        headers: {
          // 'Content-Type': 'application/x-www-form-urlencoded'
        },
      }).then((res) => {
        if(res.data.code === 1) {
          this.slides = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'cover/getCovers'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        } 
      })
    },
    getJtvBanners() {
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'cover/getCovers',
        params: {
          type: 'jtv-banner',
        },
        headers: {
          // 'Content-Type': 'application/x-www-form-urlencoded'
        },
      }).then((res) => {
        if(res.data.code === 1) {
          this.jtvBanners = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'cover/getCovers'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
      })
    },
    getMeaningNameList() {
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'category/getCategories',
        params: {
          typeName: this.typeName,
        },
        headers: {
          // 'Content-Type': 'application/x-www-form-urlencoded'
        },
      }).then((res) => {
        if(res.data.code === 1) {
          this.meaningNameList = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'category/getCategories'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
      })
    },
    getMeaningList() {
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'flower/getByType',
        params: {
          key: this.typeName,
          value: this.meaningCategoryId,
        },
        headers: {
          // 'Content-Type': 'application/x-www-form-urlencoded'
        },
      }).then((res) => {
        if(res.data.code === 1) {
          this.meaningList = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'flower/getByType'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
        
      })
    },
    getHotList() {
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'flower/getFive',
      }).then((res) => {
        if(res.data.code === 1) {
         this.hotList = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'flower/getFive'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
      })
    },
    getNew(){
      this.axios({
        method: 'get',
        url: this.GLOBAL.BASE_URL + 'flower/getNew',
      }).then((res) => {
        if(res.data.code === 1) {
          this.newList = res.data.data
        }
        if(res.data.code !== 1){
          console.log('接口'+this.GLOBAL.BASE_URL + 'flower/getNew'+'请求失败')
          console.log('原因为：'+res.data.msg,'状态码为：'+res.data.code)
        }
      })
    },
    toDetail(flowerId){
      let routerJump = this.$router.resolve({ path: '/detail',query:{id:flowerId}});
			window.open(routerJump.href, '_blank');
    }
  },
  created() {
    this.getSlides()
    this.getJtvBanners()
    this.getMeaningNameList()
    this.getMeaningList()
    this.getHotList()
    this.getNew()

  },
}
</script>

<style>
.el-tab-pane {
  color: #0000ff;
}
</style>
