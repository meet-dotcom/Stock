package com.ming.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.stock.mapper.SysLogMapper;
import com.ming.stock.pojo.entity.SysLog;
import com.ming.stock.service.LogService;
import com.ming.stock.vo.req.LogPageReqVo;
import com.ming.stock.vo.resp.PageResult;
import com.ming.stock.vo.resp.R;
import com.ming.stock.vo.resp.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author by Ming
 * @Description 日志操作服务实现
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public R<PageResult> logPageQuery(LogPageReqVo vo) {
        if (vo==null) {
            return R.error(ResponseCode.DATA_ERROR.getMessage()) ;
        }
        //组装数据
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        //分页查询
        List<SysLog> logList=this.sysLogMapper.findByCondition(vo.getUsername(),vo.getOperation(),vo.getStartTime(),vo.getEndTime());
        //封装PageResult
        PageResult<SysLog> pageResult = new PageResult<>(new PageInfo<>(logList));
        return R.ok(pageResult);
    }

    /**
     * 根据日志id集合批量删除日志信息
     * @param logIds
     * @return
     */
    @Override
    public R<String> deleteBatch(List<Long> logIds) {
        if (CollectionUtils.isEmpty(logIds)) {
            return R.error(ResponseCode.DATA_ERROR.getMessage());
        }
        this.sysLogMapper.deleteBatchByLogIds(logIds);
        return R.ok(ResponseCode.SUCCESS.getMessage());
    }
}