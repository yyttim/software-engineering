<template>
  <div>
    <el-card>
      <!--搜索栏-->
      <el-row type="flex">
        <el-col :span="8">
          <el-input v-model="query" placeholder="请输入健康数据日期查询">
            <el-button
                round
                slot="append"
                icon="iconfont icon-search-button"
                @click="requestHealthDatas"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="1"></el-col>
      </el-row>
      <el-row type="flex">
        <el-col :span="6">
          <br/>
          <el-button size="small" type="success" style="font-size: 15px" @click="addFormVisible = true">
            <i class="iconfont icon-add-button" style="font-size: 15px;"></i>
            增加今日健康数据
          </el-button>
        </el-col>
      </el-row>

      <!--表格 -->
      <el-table :data="healthData" size="small" stripe style="width: 100%" border>
        <el-table-column label="编号" prop="hdId"/>
        <el-table-column label="身高（cm）" prop="hdHeight"/>
        <el-table-column label="体重（kg）" prop="hdWeight"/>
        <el-table-column label="体温（°C）" prop="hdTemperature"/>
        <el-table-column label="健康建议" width="500">
          <template slot-scope="scope">
            <div style="white-space: pre-wrap;"> {{scope.row.hdAdvise}} </div>
          </template>
        </el-table-column>
        <el-table-column label="日期" prop="hdDate"/>
        <el-table-column label="操作" width="150" fixed="right">
          <template slot-scope="scope">
            <el-button
                size="small"
                style="font-size: 14px"
                type="success"
                @click="modifyDialog(scope.row.hdId)"
            ><i class="iconfont icon-edit-button" style="font-size: 12px;"></i></el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :current-page="pageNumber"
          :page-size="size"
          :page-sizes="[1, 2, 4, 8, 16]"
          :total="total"
      >
      </el-pagination>
    </el-card>

    <!-- 增加今日健康数据对话框 -->
    <el-dialog title="增加今日健康数据" :visible.sync="addFormVisible">
      <el-form :model="addForm" :rules="rules" ref="ruleForm">
        <el-form-item label="编号" prop="hdId" label-width="100px">
          <el-input v-model.number="addForm.hdId"></el-input>
        </el-form-item>
        <el-form-item label="身高（cm）" prop="hdHeight" label-width="100px">
          <el-input v-model.number="addForm.hdHeight"></el-input>
        </el-form-item>
        <el-form-item label="体重（kg）" prop="hdWeight" label-width="100px">
          <el-input v-model="addForm.hdWeight"></el-input>
        </el-form-item>
        <el-form-item label="体温（°C）" prop="hdTemperature" label-width="100px">
          <el-input v-model="addForm.hdTemperature"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" @click="addFormVisible = false" style="font-size: 18px;">
          <i class="iconfont icon-cancel-button" style="font-size: 20px;"></i> 取 消
        </el-button>
        <el-button size="mini" type="primary" @click="addHealthData('ruleForm')"style="font-size: 18px;">
          <i class="iconfont icon-sure-button" style="font-size: 20px;"></i> 确 定
        </el-button>
      </div>
    </el-dialog>

    <!-- 修改健康数据药物对话框 -->
    <el-dialog title="修改健康数据" :visible.sync="modifyFormVisible">
      <el-form :model="modifyForm" :rules="rules" ref="ruleForm">
        <el-form-item label="编号" prop="hdId" label-width="100px">
          <el-input
              v-model.number="modifyForm.hdId"
              disabled
          ></el-input>
        </el-form-item>
        <el-form-item label="身高（cm）" prop="hdHeight" label-width="100px">
          <el-input v-model.number="modifyForm.hdHeight"></el-input>
        </el-form-item>
        <el-form-item label="体重（kg）" prop="hdWeight" label-width="100px">
          <el-input v-model="modifyForm.hdWeight"></el-input>
        </el-form-item>
        <el-form-item label="体温（°C）" prop="hdTemperature" label-width="100px">
          <el-input v-model="modifyForm.hdTemperature"></el-input>
        </el-form-item>
        <el-form-item label="日期" prop="hdDate" label-width="100px">
          <el-input
              v-model.number="modifyForm.hdDate"
              disabled
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="modifyFormVisible = false" style="font-size: 18px;">
          <i class="iconfont icon-cancel-button" style="font-size: 20px;"></i> 取 消
        </el-button>
        <el-button size="mini"  type="primary" @click="modifyHealthData('ruleForm')"
                   style="font-size: 18px;"><i class="iconfont icon-r-yes" style="font-size: 20px;"></i> 确 定
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import jwtDecode from "jwt-decode";
import request from "@/utils/request.js";
import {getToken} from "@/utils/storage";
export default {
  name: "HealthDataList2",
  data() {
    return {
      userId: 1,
      pageNumber: 1,
      size: 8,
      query: "",
      healthData: [],
      total: 3,
      addFormVisible: false,
      addForm: {},
      rules: {
        hdId: [
          {required: true, message: "请输入编号", trigger: "blur"},
          {
            type: "number",
            message: "编号必须数字类型",
            trigger: "blur",
          },
        ],
        hdHeight: [
          {required: true, message: "请输入身高", trigger: "blur"},
          {
            type: "number",
            message: "身高必须数字类型",
            trigger: "blur",
          },
        ],
        hdWeight: [
          {required: true, message: '请输入身高', trigger: 'blur'},
          {
            validator: (rule, value, callback) => {
              const regex = /^(\d+|\d+\.\d|^\.\d+)$/;
              if (regex.test(value)) {
                callback();
              } else {
                callback(new Error('请输入整数或者一位小数'));
              }
            },
            trigger: 'blur'
          }
        ],
        hdTemperature: [
          {required: true, message: '请输入体温', trigger: 'blur'},
          {
            validator: (rule, value, callback) => {
              const regex = /^(\d+|\d+\.\d|^\.\d+)$/;
              if (regex.test(value)) {
                callback();
              } else {
                callback(new Error('请输入整数或者一位小数'));
              }
            },
            trigger: 'blur'
          }
        ]
      },
      modifyFormVisible: false,
      modifyForm: {},
    };
  },
  methods: {
    //点击修改药物信息
    modifyHealthData(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const advise = this.getHealthAdvise(this.modifyForm.hdHeight, this.modifyForm.hdWeight, this.modifyForm.hdTemperature);
          request
              .get("health/modifyHealthData", {
                params: {
                  hdId: this.modifyForm.hdId,
                  hdHeight: this.modifyForm.hdHeight,
                  hdWeight: this.modifyForm.hdWeight,
                  hdTemperature: this.modifyForm.hdTemperature,
                  hdAdvise: advise,
                  hdDate: this.modifyForm.hdDate,
                  pId: this.modifyForm.pId,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error("修改健康数据信息失败！");
                this.modifyFormVisible = false;
                this.requestHealthDatas();
                this.$message.success("修改健康数据信息成功！");
              });
        } else {
          return false;
        }
      });
    },
    //打开修改对话框
    modifyDialog(id) {
      request
          .get("health/findHealthData", {
            params: {
              hdId: id,
            },
          })
          .then((res) => {
            if (res.data.status !== 200)
              return this.$message.error("请求数据失败");
            this.modifyForm = res.data.data;
            this.modifyFormVisible = true;
          });
    },
    //删除健康数据操作
    deleteHealthData(id) {
      request
          .get("health/deleteHealthData", {
            params: {
              hdId: id,
            },
          })
          .then((res) => {
            this.requestHealthDatas();
          });
    },
    //删除对话框
    deleteDialog(id) {
      this.$confirm("此操作将删除该健康数据信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            this.deleteHealthData(id);
            this.$message({
              type: "success",
              message: "删除成功!",
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
    },
    //点击增加确认按钮
    addHealthData(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const date = this.getTodayDate();
          const advise = this.getHealthAdvise(this.addForm.hdHeight, this.addForm.hdWeight, this.addForm.hdTemperature);
          console.log(advise);
          let ok = true;
          this.healthData.forEach((item, index) => {
            if (item.hdDate === date)
              ok = false;
          });
          if (!ok) {
            return this.$message.error(
                "今日健康数据已存在！"
            );
          }
          request
              .get("health/addHealthData", {
                params: {
                  hdId: this.addForm.hdId,
                  hdHeight: this.addForm.hdHeight,
                  hdWeight: this.addForm.hdWeight,
                  hdTemperature: this.addForm.hdTemperature,
                  hdAdvise: advise,
                  hdDate: date,
                  pId: this.userId,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error(
                      "编号不合法或已被占用！"
                  );
                this.addFormVisible = false;
                this.requestHealthDatas();
                this.$message.success("增加今日健康数据成功！");
              });
        } else {
          return false;
        }
      });
    },
    //页面大小改变时触发
    handleSizeChange(size) {
      this.size = size;
      this.requestHealthDatas();
    },
    //页码改变时触发
    handleCurrentChange(num) {
      this.pageNumber = num;
      this.requestHealthDatas();
    },
    //加载健康数据列表
    requestHealthDatas() {
      request
          .get("health/findHealthDatasByPid", {
            params: {
              pId: this.userId,
            },
          })
          .then((res) => {
            this.healthData = res.data.data;
            this.total = res.data.data.total;
          });
    },
    //token解码
    tokenDecode(token) {
      if (token !== null)
        return jwtDecode(token);
    },
    getTodayDate() {
      let now = new Date();
      let year = now.getFullYear();
      let month = (now.getMonth() + 1).toString().padStart(2, '0');
      let day = now.getDate().toString().padStart(2, '0');
      return `${year}-${month}-${day}`;
    },
    getHealthAdvise(hdHeight, hdWeight, hdTemperature) {
      let advise = "";
      let BMI = 10000 * hdWeight / hdHeight / hdHeight;
      if (BMI < 18.5) {
        advise = "1. 您现在体重过轻，建议您适当增加瘦肉、鱼、虾、鸡蛋、牛奶等食物摄入。\n";
      } else if (BMI >= 18.5 && BMI <= 23.9) {
        advise = "1. 您现在体重正常，建议您继续保持。\n";
      } else if (BMI >= 24 && BMI <= 27.9) {
        advise = "1. 您现在体重超重，建议您尝试高蛋白、低油脂、低碳水饮食，多吃蛋白质丰富的食物，搭配新鲜蔬菜，减少对米饭、面食等碳水化合物的摄入，控制油脂的摄入。\n";
      } else {
        advise = "1. 您现在体重肥胖，建议您饮食上少吃肥肉、坚果、油炸食品、点心等高油、高糖、高脂肪的食物，可以选择芦笋、西蓝花、胡萝卜、瘦肉等粗纤维和热量低的食物，此外，建议您加上运动锻炼,锻炼的项目可以选游泳、跑步、跳绳、爬山等。\n";
      }
      if (hdTemperature < 36.0) {
        advise += "2. 您现在体温过低，建议您适当添加衣物进行保暖。\n";
      } else if (hdTemperature >= 36.0 && hdTemperature <= 37.2) {
        advise += "2. 您现在体温正常，建议您继续保持。\n";
      } else if (hdTemperature >= 37.3 && hdTemperature <= 37.9) {
        advise += "2. 您现在处于低烧，建议您多喝温开水、温水擦浴、贴退热贴等方法进行物理降温。\n";
      } else if (hdTemperature >= 38.0 && hdTemperature <= 40.0) {
        advise += "2. 您现在处于高烧，建议您物理降温可用冷毛巾、冰袋、化学制冷袋等局部降温，还可以温水擦浴、酒精擦浴全身降温；也可以用药物降温，比如口服布洛芬或对乙酰氨基酚、静脉注射阿司匹林或肛门塞入退热栓，甚至应用糖皮质激素地塞米松等降温。\n";
      } else {
        advise += "2. 您现在处于超高烧，情况严重，建议您马上到医院就诊。\n";
      }
      return advise;
    }

  },
  created() {
    this.userId = this.tokenDecode(getToken()).pId;
    this.requestHealthDatas();
  },
};
</script>
<style scoped lang="scss">
.el-table {
  margin-top: 20px;
  margin-bottom: 20px;
}
.el-form {
  margin-top: 0;
}
</style>
