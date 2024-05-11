<template>
  <div>
    <el-card>
      <!--搜索栏-->
      <el-row type="flex">
        <el-col :span="8">
          <el-input v-model="query" placeholder="请输入咨询标题查询">
            <el-button
                round
                slot="append"
                icon="iconfont icon-search-button"
                @click="requestQas"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="1"></el-col>
      </el-row>

      <!--表格 -->
      <el-table :data="qaData" size="small" stripe style="width: 100%" border>
        <el-table-column label="编号" prop="qaId"/>
        <el-table-column label="标题" prop="qaTitle"/>
        <el-table-column label="咨询记录" prop="qaHistory" show-overflow-tooltip/>
        <el-table-column label="操作" width="200" fixed="right">
          <template slot-scope="scope">
            <el-button
                size="small"
                style="font-size: 14px"
                type="danger"
                @click="deleteDialog(scope.row.qaId)"
            ><i class="iconfont icon-delete-button" style="font-size: 12px;"></i></el-button>
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


    <!-- 咨询记录对话框 -->
    <el-dialog title="咨询记录" :visible.sync="modifyFormVisible">
      <div>
        <p style="white-space: pre-wrap;">{{ modifyForm.qaHistory }}</p>
      </div>
      <el-form :model="modifyForm" :rules="rules" ref="ruleForm">
        <el-form-item label="" prop="qaMassage" label-width="0px">
          <el-input type="textarea"
                    v-model="modifyForm.qaMessage"
                    autosize
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="modifyFormVisible = false" style="font-size: 18px;">
          <i class="iconfont icon-cancel-button" style="font-size: 20px;"></i> 取 消
        </el-button>
        <el-button size="mini"  type="primary" @click="modifyQa('ruleForm')"
                   style="font-size: 18px;"><i class="iconfont icon-r-yes" style="font-size: 20px;"></i> 发 送
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
  name: "QaList",
  data() {
    return {
      userId:1,
      userName: "",
      pageNumber: 1,
      size: 8,
      query: "",
      qaData: [],
      total: 3,
      addFormVisible: false,
      addForm: {},

      rules: {
        qaId: [
          { required: true, message: "请输入编号", trigger: "blur" },
          {
            type: "number",
            message: "账号必须数字类型",
            trigger: "blur",
          },
        ],
        qaTitle: [
          { required: true, message: "请输入标题", trigger: "blur" },
          {
            min: 1,
            max: 50,
            message: "账号必须是1到50个字符",
            trigger: "blur",
          },
        ],
        qaHistory: [
          { required: true, message: "请输入咨询记录", trigger: "blur" },
        ],
      },
      modifyFormVisible: false,
      modifyForm: {},
    };
  },
  methods: {
    //点击修改信息
    modifyQa(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("qa/modifyQa", {
                params: {
                  qaId: this.modifyForm.qaId,
                  qaTitle: this.modifyForm.qaTitle,
                  qaHistory: this.modifyForm.qaHistory + '【' + this.userName + '】' + this.getCurrentTime() + '\n  ' + this.modifyForm.qaMessage + '\n\n',
                  pId: this.modifyForm.pId,
                  pName: this.modifyForm.pName,
                  dId: this.modifyForm.dId,
                  dName: this.modifyForm.dName,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error("发送咨询信息失败！");
                this.modifyFormVisible = false;
                this.requestQas();
                this.$message.success("发送咨询信息成功！");
              });
        } else {
          return false;
        }
      });
    },
    //打开修改对话框
    modifyDialog(id) {
      request
          .get("qa/findQa", {
            params: {
              qaId: id,
            },
          })
          .then((res) => {
            if (res.data.status !== 200)
              return this.$message.error("请求数据失败");
            this.modifyForm = res.data.data;
            this.modifyFormVisible = true;
          });
    },
    //删除咨询操作
    deleteQa(id) {
      request
          .get("qa/deleteQa", {
            params: {
              qaId: id,
            },
          })
          .then((res) => {
            this.requestQas();
          });
    },
    //删除对话框
    deleteDialog(id) {
      this.$confirm("此操作将删除该咨询信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            this.deleteQa(id);
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
    //点击发起确认按钮
    addQa(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("qa/addQa", {
                params: {
                  qaId: this.addForm.qaId,
                  qaTitle: this.addForm.qaTitle,
                  qaHistory: '【' + this.userName + '】' + this.getCurrentTime() + '\n  ' + this.addForm.qaHistory + '\n\n',
                  pId: this.userId,
                  pName: this.userName,
                  dId: -1,
                  dName: "",
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error(
                      "编号不合法或已被占用！"
                  );
                this.addFormVisible = false;
                this.requestQas();
                this.$message.success("发起咨询成功！");
              });
        } else {
          return false;
        }
      });
    },
    //页面大小改变时触发
    handleSizeChange(size) {
      this.size = size;
      this.requestQas();
    },
    //页码改变时触发
    handleCurrentChange(num) {
      this.pageNumber = num;
      this.requestQas();
    },
    //加载咨询列表
    requestQas() {
      request
          .get("qa/findAllQas", {
            params: {
              pageNumber: this.pageNumber,
              size: this.size,
              query: this.query,
            },
          })
          .then((res) => {
            this.qaData = res.data.data.qas;
            this.total = res.data.data.total;
          });
    },
    //token解码
    tokenDecode(token) {
      if (token !== null)
        return jwtDecode(token);
    },
    getCurrentTime() {
      const now = new Date();
      const year = now.getFullYear();
      const month = this.padNumber(now.getMonth() + 1);
      const day = this.padNumber(now.getDate());
      const hours = this.padNumber(now.getHours());
      const minutes = this.padNumber(now.getMinutes());
      const seconds = this.padNumber(now.getSeconds());
      return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    },
    padNumber(num) {
      return num < 10 ? '0' + num : num;
    },

  },
  created() {
    this.userId = this.tokenDecode(getToken()).pId;
    this.userName = this.tokenDecode(getToken()).pName;
    this.requestQas();
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
