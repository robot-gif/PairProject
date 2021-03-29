<template>
  <div class="search">
    <div id="srh">
      <el-select id="sec" v-model="value" placeholder="请选择">
        <el-option v-for="item in types" :key="item.value" :value="item.value">
          <div style="color: #000; font-size: 18px">{{ item.value }}</div>
        </el-option>
      </el-select>
      <el-input v-model="cont"></el-input>
      <el-button type="primary" @click.native="searchArticle()">搜索</el-button>
    </div>

      <ArticleItemView
        v-for="item in showArr"
        :key="item.id"
        :itemObj="item"
        @delete="getContent"
      />

    <div>
      <button class="prior" @click="formerPage()">&lt;上一页</button>
      <button class="next" @click="nextPage()">&gt;下一页</button>
    </div>
  </div>
</template>

<script>
import ArticleItemView from "@/components/ArticleItemView";
import bus from '@/assets/eventBus';
import axios from "axios";
export default {
  components: { ArticleItemView },
  data() {
    return {
      listArr: [],
      showArr: [],
      pageNum: 0,
      pageSize: 5,

      types: [
        {
          value: "论文名",
        },
        {
          value: "关键词",
        },
        {
          value: "编号",
        },
      ],
      value: "论文名",
      cont: "",
    };
  },
  methods: {
    query(){
      this.$http
        .post('http://localhost:8081//essay', {

        })
        .then(res => {
          this.listArr=res.data
          this.showArr=this.listArr.filter((item, index) =>
            index < (this.pageNum + 1) * this.pageSize &&
            index >= this.pageSize * this.pageNum)

        })
        .catch(failResponse => {
        })
    },
    getList() {
      if (this.cont !== "") {
        if(this.value==="论文名"){
          this.showArr = this.listArr.filter((item, index) =>
            item.title.includes(this.cont));
        }else if(this.value==="关键词"){
             // this.listArr = this.listArr.filter((item, index) =>
             //    item.spArr.indexOf(this.cont));
        }

      }else{
        this.showArr=this.listArr
      }
      this.showArr = this.showArr.filter(
        (item, index) =>
          index < (this.pageNum + 1) * this.pageSize &&
          index >= this.pageSize * this.pageNum
      );

    },

    searchArticle() {
      this.pageNum = 0;
      this.getList();
    },
    nextPage() {
      if ((this.pageNum + 1) * this.pageSize > this.showArr.length) {
        alert("已经到最后一页了!");
      } else {
        this.pageNum++;
        this.getList();
      }
    },
    formerPage() {
      if (this.pageNum > 0) {
        this.pageNum--;
        this.getList();
      } else {
        alert("已经在第一页了!");
      }
    },
    getContent(){

      this.showArr.splice(this.item.id,1)
    }


  },
  created() {
    this.query();
  },
  mounted() {
    this.query();
    bus.$on("delete", id => {
      for(let i=0;i<this.showArr.length;i++){
        if(this.listArr[i].id===id){
          this.listArr.splice(i,1)
        }

      }
      this.getList();
    });
    this.getList();
  }
};
</script>

<style lang="less" scoped>
.search {
  height: 100%;
  background-color: rgb(214, 234, 234);
  min-height: 1200px;
}
#srh {
  height: 180px;
  /deep/.el-select {
    display: inline-block;
    font-size: 20px;
    height: 55px;
    width: 140px;
    margin-top: 55px;
    margin-left: 680px;
  }

  /deep/.el-input {
    width: 400px;
    height: 55px;

    /deep/.el-input__inner {
      background-color: #fff;
      background-image: none;
      border-radius: 4px;
      border: 1px solid #dcdfe6;
      box-sizing: border-box;
      color: #131314;
      display: inline-block;
      font-size: 20px;
      height: 55px !important;
      line-height: 55px !important;
      width: 100%;
    }
  }
  /deep/.el-button--primary {
    color: #fff;
    background-color: #3e4042;
    border-color: #212122;
    width: 140px;
    height: 55px;
    font-size: 17pt;
  }
}
.next {
  height: 40px;
  width: 80px;
}
.prior {
  margin-left: 900px;
  height: 40px;
  width: 80px;
}
</style>
