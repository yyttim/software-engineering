<template>
  <div>
    <el-card>
      <!--搜索栏-->
      <el-row type="flex">
        <el-col :span="8">
          <el-input v-model="query" placeholder="请输入疾病名称查询">
            <el-button
                round
                slot="append"
                icon="iconfont icon-search-button"
                @click="requestDiseases"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="1"></el-col>
      </el-row>


      <!--表格 -->
      <el-table :data="diseaseData" size="small" stripe style="width: 100%" border>
        <el-table-column label="编号" prop="deId"/>
        <el-table-column label="疾病" prop="deName"/>
        <el-table-column label="症状" prop="deSymptom"/>
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

  </div>
</template>
<script>
import request from "@/utils/request.js";
export default {
  name: "DiseaseList2",
  data() {
    return {
      pageNumber: 1,
      size: 8,
      query: "",
      diseaseData: [],
      total: 3,
      addFormVisible: false,
      addForm: {},
      rules: {
        deId: [
          { required: true, message: "请输入编号", trigger: "blur" },
          {
            type: "number",
            message: "账号必须数字类型",
            trigger: "blur",
          },
        ],
        deName: [
          { required: true, message: "请输入名称", trigger: "blur" },
          {
            min: 1,
            max: 50,
            message: "账号必须是1到50个字符",
            trigger: "blur",
          },
        ],
        deSymptom: [
          { required: true, message: "请输入症状", trigger: "blur" },
        ],
      },
      modifyFormVisible: false,
      modifyForm: {},
    };
  },
  methods: {
    //点击修改药物信息
    modifyDisease(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("disease/modifyDisease", {
                params: {
                  deId: this.modifyForm.deId,
                  deName: this.modifyForm.deName,
                  deSymptom: this.modifyForm.deSymptom,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error("修改疾病信息失败！");
                this.modifyFormVisible = false;
                this.requestDiseases();
                this.$message.success("修改疾病信息成功！");
              });
        } else {
          return false;
        }
      });
    },
    //打开修改对话框
    modifyDialog(id) {
      request
          .get("disease/findDisease", {
            params: {
              deId: id,
            },
          })
          .then((res) => {
            if (res.data.status !== 200)
              return this.$message.error("请求数据失败");
            this.modifyForm = res.data.data;
            this.modifyFormVisible = true;
          });
    },
    //删除疾病操作
    deleteDisease(id) {
      request
          .get("disease/deleteDisease", {
            params: {
              deId: id,
            },
          })
          .then((res) => {
            this.requestDiseases();
          });
    },
    //删除对话框
    deleteDialog(id) {
      this.$confirm("此操作将删除该疾病信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            this.deleteDisease(id);
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
    addDisease(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("disease/addDisease", {
                params: {
                  deId: this.addForm.deId,
                  deName: this.addForm.deName,
                  deSymptom: this.addForm.deSymptom,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error(
                      "编号不合法或已被占用！"
                  );
                this.addFormVisible = false;
                this.requestDiseases();
                this.$message.success("增加疾病成功！");
              });
        } else {
          return false;
        }
      });
    },
    //页面大小改变时触发
    handleSizeChange(size) {
      this.size = size;
      this.requestDiseases();
    },
    //页码改变时触发
    handleCurrentChange(num) {
      this.pageNumber = num;
      this.requestDiseases();
    },
    //加载疾病列表
    requestDiseases() {
      request
          .get("disease/findAllDiseases", {
            params: {
              pageNumber: this.pageNumber,
              size: this.size,
              query: this.query,
            },
          })
          .then((res) => {
            this.diseaseData = res.data.data.diseases;
            this.total = res.data.data.total;
          });
    },
  },
  created() {
    this.requestDiseases();
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
