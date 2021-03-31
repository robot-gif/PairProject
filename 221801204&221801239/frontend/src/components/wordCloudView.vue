<template>
  <div id="container">
    <div id="top">
      <div id="myWordCloud" :style="{width: '100%', height: '400px'}" :data="wordData"></div>
      <!--            <ArticleItemView  v-for="item in showArray"-->
      <!--                              :key="item.id"-->
      <!--                              :itemObj="item"-->
      <!--            />-->
    </div>
  </div>


</template>

<script>
import bus from "@/assets/eventBus";
import ArticleItemView from "@/components/ArticleItemView";

const echarts = require('echarts');
const wordCloud = require('echarts-wordcloud');
export default {
  name: "wordCountView",
  components: {},
  data() {
    return {
      msg: '',
      wordData: [
        {
          name: "",
          value: 0
        }
      ],
      listArray: [
        {
          title: "",
          keyword: [],
          abstracted: "",
          link: "",
          paper_id: "",
          publication_year: ""
        }
      ],
      showArray: []
    }
  },
  methods: {
    // query(){
    //   this.$axios
    //     .get('http://localhost:8083/changepage', {
    //
    //     })
    //     .then(res => {
    //       this.listArray=res.data
    //       this.getList()
    //     })
    //     .catch(failResponse => {
    //     })
    // },
    // getList() {
    //   this.showArray = this.listArray.filter((item, index) =>
    //     item.keyword.indexOf(this.wordData.name) > -1);
    // },
    initChart() {
      let chart
      if (chart != null) {
        chart.dispose()
      }
      chart = echarts.init(document.getElementById("myWordCloud"));

      chart.setOption({
        title: {
          text: "Top10热词词云图",
          x: "center"
        },
        series: [
          {
            type: "wordCloud",
            gridSize: 10,
            sizeRange: [14, 50],
            rotationRange: [0, 0],
            textStyle: {
              normal: {
                color: function () {
                  return (
                    "rgb(" +
                    Math.round(Math.random() * 255) +
                    ", " +
                    Math.round(Math.random() * 255) +
                    ", " +
                    Math.round(Math.random() * 255) +
                    ")"
                  );
                }
              }
            },
            left: "center",
            top: "center",
            right: null,
            bottom: null,
            width: "200%",
            height: "200%",
            //数据
            data: this.wordData
          }
        ]
      })
      chart.on('click', (params) => {
        this.query()
      });

    },
    getData() {
      this.$axios
        .get('http://localhost:8083/gettopwords', {})
        .then(res => {
          this.wordData = res.data
        })
        .catch(failResponse => {
        })
    }

  }, created() {
    this.getData()

  },
  mounted() {
    this.$nextTick(this.initChart())
  },
  updated() {

    this.initChart()
  }

}
</script>

<style scoped lang="less">
#container {
  width: 100%;
  height: 100%;
  min-height: 1400px;
  background-color: #D6EAEA;

  #top {
    background-color: #D6EAEA;
  }
}

</style>
